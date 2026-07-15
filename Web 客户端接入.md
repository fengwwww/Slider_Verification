> **注意：**
> 
> - 自2024年11月04日起，验证码2.0正式发布，启用验证码2.0 JS 地址：`https://turing.captcha.qcloud.com/TJCaptcha.js`，详情请参见[天御验证码 2.0版发布公告](https://cloud.tencent.com/document/product/1110/112026)。原有验证码1.0 JS 地址：`https://turing.captcha.qcloud.com/TCaptcha.js` 仍正常提供服务，用户可根据自身需求选择使用。
> - CaptchaAppid 鉴权通过前端传递加密符（aidEncrypted 参数），可有效防止因 CaptchaAppid 泄露导致的资源盗刷风险，建议您开启此功能。详情参见 [验证码 CaptchaAppid 鉴权升级指引](https://cloud.tencent.com/document/product/1110/128489)。


## 前提条件

客户端接入前，需完成新建验证，并在**验证列表**获取所需的 CaptchaAppId 以及 AppSecretKey。步骤如下：
1. 登录 [验证码控制台](https://console.cloud.tencent.com/captcha/graphical)，左侧导航栏选择**图形验证** > **验证管理**，进入验证管理页面。

2. 单击**新建验证**，根据业务场景需求，设置验证名称、客户端类型、验证方式等参数。

3. 单击**确定**，完成新建验证，即可在验证列表中查看验证码 CaptchaAppId 及 AppSecretKey。


## 代码示例

以下代码示例，单击**验证**，激活验证码，并弹窗展示验证结果。

> **注意**
> 

> 该示例未展示调用票据校验 API 的逻辑。业务客户端完成验证码接入后，业务服务端需二次核查验证码票据结果（未接入票据校验，会导致黑产轻易伪造验证结果，失去验证码人机对抗效果），详情请参见：[接入票据校验（Web 及 App）](https://cloud.tencent.com/document/product/1110/75489)。
> 

``` bash

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Web 前端接入示例</title>
    <!-- 验证码程序依赖(必须)。请勿修改以下程序依赖，如通过其他手段规避加载，会导致验证码无法正常更新，对抗能力无法保证，甚至引起误拦截。 -->
    <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
  </head>

  <body>
    <button id="CaptchaId" type="button">验证</button>
  </body>

  <script>
    // 定义回调函数
    function callback(res) {
      // 第一个参数传入回调结果，结果如下：
      // ret         Int       验证结果，0：验证成功。2：用户主动关闭验证码。
      // ticket      String    验证成功的票据，当且仅当 ret = 0 时 ticket 有值。
      // CaptchaAppId       String    验证码应用ID。
      // bizState    Any       自定义透传参数。
      // randstr     String    本次验证的随机串，后续票据校验时需传递该参数。
      // verifyDuration     Int   验证码校验接口耗时（ms）。
      // actionDuration     Int   操作校验成功耗时（用户动作+校验完成）(ms)。
      // sid     String   链路sid。

      console.log('callback:', res);

      // res（用户主动关闭验证码）= {ret: 2, ticket: null}
      // res（验证成功） = {ret: 0, ticket: "String", randstr: "String"}
      // res（请求验证码发生错误，验证码自动返回trerror_前缀的容灾票据） = {ret: 0, ticket: "String", randstr: "String",  errorCode: Number, errorMessage: "String"}
      // 此处代码仅为验证结果的展示示例，真实业务接入，建议基于ticket和errorCode情况做不同的业务处理
      if (res.ret === 0) {
        // 复制结果至剪切板
        var str = '【randstr】->【' + res.randstr + '】      【ticket】->【' + res.ticket + '】';
        var ipt = document.createElement('input');
        ipt.value = str;
        document.body.appendChild(ipt);
        ipt.select();
        document.execCommand('Copy');
        document.body.removeChild(ipt);
        alert('1. 返回结果（randstr、ticket）已复制到剪切板，ctrl+v 查看。2. 打开浏览器控制台，查看完整返回结果。');
      }
    }

    // 定义验证码js加载错误处理函数
    function loadErrorCallback() {
      var appid = '您的CaptchaAppId';
      // 生成容灾票据或自行做其它处理
      var ticket = 'trerror_1001_' + appid + '_' + Math.floor(new Date().getTime() / 1000);
      callback({
        ret: 0,
        randstr: '@' + Math.random().toString(36).substr(2),
        ticket: ticket,
        errorCode: 1001,
        errorMessage: 'jsload_error',
      });
    }

    // 定义验证码触发事件
    window.onload = function () {
      document.getElementById('CaptchaId').onclick = function () {
        try {
          // 生成一个验证码对象
          // CaptchaAppId：登录验证码控制台，从【验证管理】页面进行查看。如果未创建过验证，请先新建验证。注意：不可使用客户端类型为小程序的CaptchaAppId，会导致数据统计错误。
          //callback：定义的回调函数
          var captcha = new TencentCaptcha('您的验证码CaptchaAppId', callback, {
            userLanguage: 'zh-cn',
            showFn: (ret) => {
              const {
                duration, // 验证码渲染完成的耗时(ms)
                sid, // 链路sid
              } = ret;
            },
            verifyFn: (data) => {
              // 校验结果+sid 回调函数
              const { pass, sid } = data;
              // pass: true 校验通过, false 校验未通过
              // sid: 此次校验的sid
            },
          });
          // 调用方法，显示验证码
          captcha.show();
        } catch (error) {
          // 加载异常，调用验证码js加载错误处理函数
          loadErrorCallback();
        }
      };
    };
  </script>
</html>
```

## 接入说明

### 步骤1：动态引入验证码 JS

Web 页面需动态引入验证码 JS，在业务需要验证时，唤起验证码进行验证。
``` bash
<!-- 动态引入验证码JS示例 -->
<script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
```

> **注意**
> 

> 必须动态引入验证码 JS。如通过其他手段规避动态加载，会导致验证码无法正常更新，对抗能力无法保证，甚至引起误拦截。
> 

> 如果使用验证码1.0，请将 JS 地址改为 https://turing.captcha.qcloud.com/TCaptcha.js，其他无需变更。
> 


### 步骤2：创建验证码对象

引入验证码 JS 后，验证码会在全局注册一个`TencentCaptcha`类，业务方可以使用这个类自行初始化验证码，并对验证码进行显示或者隐藏。

> **注意**
> 

> 触发验证码的元素不要使用`id="TencentCaptcha"`，TencentCaptcha 属于系统默认 id，用来兼容验证码旧接入方式。 
> 


#### 构造函数
``` bash
new TencentCaptcha(CaptchaAppId, callback, options);
```

**参数说明**
<table>
<tr>
<td rowspan="1" colSpan="1" >参数名</td>

<td rowspan="1" colSpan="1" >值类型</td>

<td rowspan="1" colSpan="1" >说明</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >CaptchaAppId</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >验证码 CaptchaAppId：登录 <a href="https://console.cloud.tencent.com/captcha/graphical">验证码控制台</a>，在验证管理页面进行查看。如果未创建过验证，请先新建验证。<br>注意：不可使用客户端类型为小程序的 CaptchaAppId，会导致数据统计错误。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >callback</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >验证码回调函数，详情请参见 <a href="https://cloud.tencent.com/document/product/1110/36841#hdhs">callback 回调函数</a>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >options</td>

<td rowspan="1" colSpan="1" >Object</td>

<td rowspan="1" colSpan="1" >验证码外观配置参数, 详情请参见 <a href="https://cloud.tencent.com/document/product/1110/36841#pzcs">options 外观配置参数</a>。</td>
</tr>
</table>


#### callback 回调函数

验证结束后，会调用业务传入的回调函数，并在第一个参数中传入回调结果。回调结果字段说明如下：
<table>
<tr>
<td rowspan="1" colSpan="1" >字段名</td>

<td rowspan="1" colSpan="1" >值类型</td>

<td rowspan="1" colSpan="1" >说明</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ret</td>

<td rowspan="1" colSpan="1" >Int</td>

<td rowspan="1" colSpan="1" >验证结果，0：验证成功。2：用户主动关闭验证码。<br><strong>说明：</strong><br>容灾场景下验证结果返回：0，详情请参见 <a href="https://cloud.tencent.com/document/product/1110/72310">业务容灾方案（Web 及 App）</a>。<br></td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ticket</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >验证成功的票据，当且仅当 ret = 0 时 ticket 有值。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >appid</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >验证码应用 ID。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >bizState</td>

<td rowspan="1" colSpan="1" >Any</td>

<td rowspan="1" colSpan="1" >自定义透传参数。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >randstr</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >本次验证的随机串，后续票据校验时需传递该参数。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >errorCode</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >错误 code ，详情请参见 <a href="https://cloud.tencent.com/document/product/1110/36841#errorCode">回调函数 errorCode 说明</a>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >errorMessage</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >错误信息。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >verifyDuration</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >验证码校验接口耗时（ms）</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >actionDuration</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >用户操作校验成功耗时（ms）</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >sid</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >链路 sid</td>
</tr>
</table>




**回调函数 errorCode 说明**

|errorCode|说明|
|---------|---------|
|1001|TJCaptcha.js 加载错误|
|1002|调用 show 方法超时|
|1003|中间 JS 加载超时|
|1004|中间 JS 加载错误|
|1005|中间 JS 运行错误|
|1006|拉取验证码配置错误/超时（网络超时，欠费，CaptchaAppid 加密配置错误）|
|1007|iframe 加载超时|
|1008|iframe 加载错误|
|1009|jQuery 加载错误|
|1010|滑块 JS 加载错误|
|1011|滑块 JS 运行错误|
|1012|刷新连续错误3次|
|1013|验证网络连续错误3次|
|1085|无感验证超时/失败|


#### options 外观配置参数

options 参数用于对验证码进行定制外观设置，默认可以设置为空。

> **注意**
> 
> - 验证码弹窗内部不支持调整样式大小，如果需要调整，可在弹窗最外层用 class=tcaptcha-transform 的元素设置 transform:scale();（更改大小可能会导致验证码图片失真，请谨慎修改）。举例如下：
> `.tcaptcha-transform{
transform: scale(0.9);
}`
> - 验证码服务更新可能会改变元素的 id、class 等属性，请勿依赖其他验证码元素属性值覆盖样式。
> - 如果手机原生端有设置左右滑动手势，需在调用验证码 show 方法前禁用，验证完成后再打开，防止与验证码滑动事件冲突。

<table>
<tr>
<td rowspan="1" colSpan="1" >配置名</td>

<td rowspan="1" colSpan="1" >值类型</td>

<td rowspan="1" colSpan="1" >说明</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >bizState</td>

<td rowspan="1" colSpan="1" >Any</td>

<td rowspan="1" colSpan="1" >自定义透传参数，业务可用该字段传递少量数据，该字段的内容会被带入 callback 回调的对象中。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >enableDarkMode</td>

<td rowspan="1" colSpan="1" >Boolean\|String</td>

<td rowspan="1" colSpan="1" >开启自适应深夜模式或强制深夜模式。（<strong>VTT 空间语义验证暂不支持该功能</strong>）<br>1. 开启自适应深夜模式: {"enableDarkMode": true}<br>2. 强制深夜模式: {"enableDarkMode": 'force'}</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >sdkOpts</td>

<td rowspan="1" colSpan="1" >Object</td>

<td rowspan="1" colSpan="1" >示例 {"width": 140, "height": 140}<br>仅支持移动端原生 webview 调用时传入，用来设置验证码 loading 加载弹窗的大小（<strong>注意，并非验证码弹窗大小</strong>）。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ready</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >验证码加载完成的回调，回调参数为验证码实际的宽高（单位：px）：<br>{"sdkView": {<br>"width": number,<br>"height": number<br>}}<br>该参数仅为查看验证码宽高使用，<strong>请勿使用此参数直接设定宽高</strong>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >needFeedBack</td>

<td rowspan="1" colSpan="1" >Boolean\|String</td>

<td rowspan="1" colSpan="1" >隐藏帮助按钮或自定义帮助按钮链接。（<strong>VTT 空间语义验证暂不支持自定义链接</strong>） <br>隐藏帮助按钮: {"needFeedBack": false }<br>自定义帮助链接: {"needFeedBack": 'url 地址' }</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >loading</td>

<td rowspan="1" colSpan="1" >Boolean</td>

<td rowspan="1" colSpan="1" >是否在验证码加载过程中显示 loading 框。不指定该参数时，默认显示 loading 框。<br>- 显示 loading 框: {"loading": true}<br>- 不显示 loading 框: {"loading": false} （展示方式为嵌入式时不支持配置）</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >userLanguage</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >指定验证码提示文案的语言，优先级高于控制台配置。（<strong>VTT 空间语义、文字点选验证暂不支持语言配置</strong>）<br>支持传入值同 navigator.language 用户首选语言，大小写不敏感。<br>详情参见 <a href="https://cloud.tencent.com/document/product/1110/36841#userLanguage">userLanguage 配置参数</a>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >type</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >定义验证码展示方式。<br>- popup（默认）弹出式，以浮层形式居中弹出展示验证码。<br>- embed 嵌入式，以嵌入指定容器元素中的方式展示验证码。<br>弹出式尺寸360*360，当视图小于一定宽高验证码的边距30px 就会自动缩放。嵌入式尺寸300×230 不会根据屏幕大小自动缩放。详情参见 <a href="https://cloud.tencent.com/document/product/1110/36841#embed">嵌入式验证码参数配置示例</a>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >aidEncrypted</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >CaptchaAppId 加密校验串，可选参数。详情见 <a href="https://cloud.tencent.com/document/product/1110/128489">验证码 CaptchaAppid 鉴权升级指引</a>。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >showFn</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >duration 渲染耗时 + sid 回调函数。</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >verifyFn</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >用于获取每次验证校验的结果和 sid。<br>- pass（boolean）：本次校验结果，true 表示验证通过，false 表示验证未通过。<br>- sid（string）：本次校验的会话 ID。</td>
</tr>
</table>




**嵌入式验证码参数配置示例**
``` java
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>验证码-内嵌接入</title>
    <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
  </head>
  <body>
    <!-- 验证码指定的内嵌容器 可自定义到任何位置 -->
    <div id="targetEmbed"></div>
    <script>
      function globalCallback(res) {
        console.log('captcha success', res);
      }
      function errorCallback(res) {
        console.log('errorCallback', res);
      }
      window.onload = function () {
        try {
          const captcha = new TencentCaptcha(document.getElementById('targetEmbed'), '用户CaptchaAppid', globalCallback, {
            type: 'embed',
          });
          captcha.show();
        } catch (error) {
          console.log('error', error);
          errorCallback(error);
        }
      };
    </script>
  </body>
</html>

```



**userLanguage 配置参数（****除滑动拼图验证外，其他验证形式只支持中英文）**

|参数名|说明|
|---------|---------|
|zh-cn|简体中文|
|zh-hk|繁体中文（中国香港）|
|zh-tw|繁体中文（中国台湾）|
|en|英文|
|ar|阿拉伯语|
|cs-cz|捷克语（捷克）|
|de|德语|
|en-in|英语（印度）|
|es|西班牙语|
|es-la|西班牙语（拉丁美洲）|
|fil|菲律宾语|
|fr|法语|
|he|希伯来语|
|hi|印地语|
|id|印尼语|
|it|意大利语|
|ja|日语|
|ko|朝鲜语 / 韩语|
|lo|老挝语|
|ms|马来语|
|my|缅甸语|
|nl|荷兰语|
|pl|波兰语|
|pt|葡萄牙语|
|pt-pt|葡萄牙语（葡萄牙）|
|ro-ro|罗马尼亚语（罗马尼亚）|
|ru|俄语|
|th|泰语|
|tr|土耳其语|
|uk-ua|乌克兰语（乌克兰）|
|ur|乌尔都语|
|vi|越南语|


### 步骤3：调用验证码实例方法

TencentCaptcha 的实例提供一些操作验证码的常用方法：

|方法名|说明|传入参数|返回内容|
|---------|---------|---------|---------|
|show|显示验证码，可以反复调用。|无|无|
|destroy|隐藏验证码，可以反复调用。|无|无|
|getTicket|获取验证成功后的 ticket。|无|`Object:{"CaptchaAppId":"","ticket":""}`|


### 步骤4：容灾处理

为保障验证码 Captcha 服务端异常时不阻塞客户网站正常业务流程，建议参考如下方式接入验证码。
1. 定义错误处理函数。

   ``` javascript
   // 错误处理函数作用：在脚本加载或初始化错误时，保障事件流程正常
   // 函数定义需在script加载前
   function loadErrorCallback() {
    var appid = ''
    // 生成容灾票据或自行做其它处理
    var ticket = 'trerror_1001_' + appid + Math.floor(new Date().getTime() / 1000);
    callback({
        ret: 0,
        randstr: '@'+ Math.random().toString(36).substr(2),
        ticket:ticket,
        errorCode: 1001,
        errorMessage: 'jsload_error',
    });
   }
   ```
2. 验证码返回错误时，调用错误处理函数。

   ``` javascript
   try {
    // 生成一个验证码对象
    var captcha = new TencentCaptcha('您的验证码CaptchaAppId', callback, {});
    // 调用方法，显示验证码
    captcha.show(); 
   } catch (error) {
    // 加载异常，调用验证码js加载错误处理函数
    loadErrorCallback();
   }
   ```
3. 回调函数根据 ticket 和 errorCode （而非 ret）的情况做处理。

   ``` javascript
   function callback(res) {
    // res（用户主动关闭验证码）= {ret: 2, ticket: null}
    // res（验证成功） = {ret: 0, ticket: "String", randstr: "String"}
    // res（请求错误，返回trerror_前缀的容灾票据） = {ret: 0, ticket: "String", randstr: "String",  errorCode: Number, errorMessage: "String"}
    if (res.ticket){
        //根据errorCode情况做特殊处理
        if(res.errorCode === xxxxx){
           //自定义容灾逻辑（例如跳过这次验证）
        }
      }
   }
   ```

   完整容灾方案，详情请见[业务容灾方案](https://cloud.tencent.com/document/product/1110/72310)。
   

   > **注意**
   > 

   > 业务客户端完成验证码接入后，服务端需二次核查验证码票据结果（未接入票据校验，会导致黑产轻易伪造验证结果，失去验证码人机对抗效果），详情请参见：[接入票据校验（Web 及 App）](https://cloud.tencent.com/document/product/1110/75489)。
   > 


### 步骤5：CaptchaAppid 鉴权

CaptchaAppid 鉴权通过前端传递加密符（aidEncrypted 参数），可有效防止因 CaptchaAppid 泄露导致的资源盗刷风险。详情参见 [验证码 CaptchaAppid 鉴权升级指引](https://cloud.tencent.com/document/product/1110/128489)。

## React 架构接入示例
1. 在 HTML 模板文件中引入验证码 JS。

   ``` html
   <!-- 验证码程序依赖(必须)。请勿修改以下程序依赖，如使用本地缓存，或通过其他手段规避加载，会导致验证码无法正常更新，对抗能力无法保证，甚至引起误拦截。 -->
   <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
   ```
2. 调用验证码。

   ``` tsx
   
   import React from 'react';
   
   import logo from './logo.svg';
   
   import './App.css';
   
   interface ICaptchaResult {
     ret: number;
   
     ticket: string;
   
     randstr: string;
   
     CaptchaAppId?: string;
   
     bizState?: string;
   
     errorCode?: number;
   
     errorMessage?: string;
   }
   
   function App() {
     // 定义回调函数
   
     function callback(res: ICaptchaResult) {
       // 第一个参数传入回调结果，结果如下：
   
       // ret Int 验证结果，0：验证成功。2：用户主动关闭验证码。
   
       // ticket String 验证成功的票据，当且仅当 ret = 0 时 ticket 有值。
   
       // CaptchaAppId String 验证码应用ID。
   
       // bizState Any 自定义透传参数。
   
       // randstr String 本次验证的随机串，后续票据校验时需传递该参数。
   
       console.log('callback:', res);
   
       // res（用户主动关闭验证码）= {ret: 2, ticket: null}
   
       // res（验证成功） = {ret: 0, ticket: "String", randstr: "String"}
   
       // res（请求验证码发生错误，验证码自动返回trerror_前缀的容灾票据） = {ret: 0, ticket: "String", randstr: "String", errorCode: Number, errorMessage: "String"}
   
       // 此处代码仅为验证结果的展示示例，真实业务接入，建议基于ticket和errorCode情况做不同的业务处理
   
       if (res.ret === 0) {
         // 复制结果至剪切板
   
         var str = '【randstr】->【' + res.randstr + '】 【ticket】->【' + res.ticket + '】';
   
         var ipt = document.createElement('input');
   
         ipt.value = str;
   
         document.body.appendChild(ipt);
   
         ipt.select();
   
         document.execCommand('Copy');
   
         document.body.removeChild(ipt);
   
         alert('1. 返回结果（randstr、ticket）已复制到剪切板，ctrl+v 查看。 2. 打开浏览器控制台，查看完整返回结果。');
       }
     }
   
     // 定义验证码js加载错误处理函数
   
     function loadErrorCallback() {
       var appid = '您的CaptchaAppId';
   
       // 生成容灾票据或自行做其它处理
   
       var ticket = 'trerror_1001_' + appid + '_' + Math.floor(new Date().getTime() / 1000);
   
       callback({
         ret: 0,
   
         randstr: '@' + Math.random().toString(36).substr(2),
   
         ticket: ticket,
   
         errorCode: 1001,
   
         errorMessage: 'jsload_error',
       });
     }
   
     function onCaptchaShow() {
       try {
         // 生成一个验证码对象
   
         // CaptchaAppId：登录验证码控制台，从【验证管理】页面进行查看。如果未创建过验证，请先新建验证。注意：不可使用客户端类型为小程序的CaptchaAppId，会导致数据统计错误。
   
         // callback：定义的回调函数
   
         const captcha = new TencentCaptcha('您的CaptchaAppId', callback, {});
   
         // 调用方法，显示验证码
   
         captcha.show();
       } catch (error) {
         // 加载异常，调用验证码js加载错误处理函数
   
         loadErrorCallback();
       }
     }
   
     return (
       <div className='App'>
         <button className='captcha-btn' onClick={onCaptchaShow}>
           弹出验证码
         </button>
       </div>
     );
   }
   
   export default App;
   
   ```



## 常见问题

详情参见 [接入相关问题](https://cloud.tencent.com/document/product/1110/36828)。

## 更多信息

您可以登录 [验证码控制台](https://console.cloud.tencent.com/captcha/graphical)，在页面右下角单击**快速咨询**，了解更多详细信息。