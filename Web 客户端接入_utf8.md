> **娉ㄦ剰锛?**
> 
> - 鑷?2024骞?11鏈?04鏃ヨ捣锛岄獙璇佺爜2.0姝ｅ紡鍙戝竷锛屽惎鐢ㄩ獙璇佺爜2.0 JS 鍦板潃锛歚https://turing.captcha.qcloud.com/TJCaptcha.js`锛岃鎯呰鍙傝[澶╁尽楠岃瘉鐮? 2.0鐗堝彂甯冨叕鍛奭(https://cloud.tencent.com/document/product/1110/112026)銆傚師鏈夐獙璇佺爜1.0 JS 鍦板潃锛歚https://turing.captcha.qcloud.com/TCaptcha.js` 浠嶆甯告彁渚涙湇鍔★紝鐢ㄦ埛鍙牴鎹嚜韬渶姹傞?夋嫨浣跨敤銆?
> - CaptchaAppid 閴存潈閫氳繃鍓嶇浼犻?掑姞瀵嗙锛坅idEncrypted 鍙傛暟锛夛紝鍙湁鏁堥槻姝㈠洜 CaptchaAppid 娉勯湶瀵艰嚧鐨勮祫婧愮洍鍒烽闄╋紝寤鸿鎮ㄥ紑鍚鍔熻兘銆傝鎯呭弬瑙? [楠岃瘉鐮? CaptchaAppid 閴存潈鍗囩骇鎸囧紩](https://cloud.tencent.com/document/product/1110/128489)銆?


## 鍓嶆彁鏉′欢

瀹㈡埛绔帴鍏ュ墠锛岄渶瀹屾垚鏂板缓楠岃瘉锛屽苟鍦?**楠岃瘉鍒楄〃**鑾峰彇鎵?闇?鐨? CaptchaAppId 浠ュ強 AppSecretKey銆傛楠ゅ涓嬶細
1. 鐧诲綍 [楠岃瘉鐮佹帶鍒跺彴](https://console.cloud.tencent.com/captcha/graphical)锛屽乏渚у鑸爮閫夋嫨**鍥惧舰楠岃瘉** > **楠岃瘉绠＄悊**锛岃繘鍏ラ獙璇佺鐞嗛〉闈€??

2. 鍗曞嚮**鏂板缓楠岃瘉**锛屾牴鎹笟鍔″満鏅渶姹傦紝璁剧疆楠岃瘉鍚嶇О銆佸鎴风绫诲瀷銆侀獙璇佹柟寮忕瓑鍙傛暟銆?

3. 鍗曞嚮**纭畾**锛屽畬鎴愭柊寤洪獙璇侊紝鍗冲彲鍦ㄩ獙璇佸垪琛ㄤ腑鏌ョ湅楠岃瘉鐮? CaptchaAppId 鍙? AppSecretKey銆?


## 浠ｇ爜绀轰緥

浠ヤ笅浠ｇ爜绀轰緥锛屽崟鍑?**楠岃瘉**锛屾縺娲婚獙璇佺爜锛屽苟寮圭獥灞曠ず楠岃瘉缁撴灉銆?

> **娉ㄦ剰**
> 

> 璇ョず渚嬫湭灞曠ず璋冪敤绁ㄦ嵁鏍￠獙 API 鐨勯?昏緫銆備笟鍔″鎴风瀹屾垚楠岃瘉鐮佹帴鍏ュ悗锛屼笟鍔℃湇鍔＄闇?浜屾鏍告煡楠岃瘉鐮佺エ鎹粨鏋滐紙鏈帴鍏ョエ鎹牎楠岋紝浼氬鑷撮粦浜ц交鏄撲吉閫犻獙璇佺粨鏋滐紝澶卞幓楠岃瘉鐮佷汉鏈哄鎶楁晥鏋滐級锛岃鎯呰鍙傝锛歔鎺ュ叆绁ㄦ嵁鏍￠獙锛圵eb 鍙? App锛塢(https://cloud.tencent.com/document/product/1110/75489)銆?
> 

``` bash

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Web 鍓嶇鎺ュ叆绀轰緥</title>
    <!-- 楠岃瘉鐮佺▼搴忎緷璧?(蹇呴』)銆傝鍕夸慨鏀逛互涓嬬▼搴忎緷璧栵紝濡傞?氳繃鍏朵粬鎵嬫瑙勯伩鍔犺浇锛屼細瀵艰嚧楠岃瘉鐮佹棤娉曟甯告洿鏂帮紝瀵规姉鑳藉姏鏃犳硶淇濊瘉锛岀敋鑷冲紩璧疯鎷︽埅銆? -->
    <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
  </head>

  <body>
    <button id="CaptchaId" type="button">楠岃瘉</button>
  </body>

  <script>
    // 瀹氫箟鍥炶皟鍑芥暟
    function callback(res) {
      // 绗竴涓弬鏁颁紶鍏ュ洖璋冪粨鏋滐紝缁撴灉濡備笅锛?
      // ret         Int       楠岃瘉缁撴灉锛?0锛氶獙璇佹垚鍔熴??2锛氱敤鎴蜂富鍔ㄥ叧闂獙璇佺爜銆?
      // ticket      String    楠岃瘉鎴愬姛鐨勭エ鎹紝褰撲笖浠呭綋 ret = 0 鏃? ticket 鏈夊?笺??
      // CaptchaAppId       String    楠岃瘉鐮佸簲鐢↖D銆?
      // bizState    Any       鑷畾涔夐?忎紶鍙傛暟銆?
      // randstr     String    鏈楠岃瘉鐨勯殢鏈轰覆锛屽悗缁エ鎹牎楠屾椂闇?浼犻?掕鍙傛暟銆?
      // verifyDuration     Int   楠岃瘉鐮佹牎楠屾帴鍙ｈ?楁椂锛坢s锛夈??
      // actionDuration     Int   鎿嶄綔鏍￠獙鎴愬姛鑰楁椂锛堢敤鎴峰姩浣?+鏍￠獙瀹屾垚锛?(ms)銆?
      // sid     String   閾捐矾sid銆?

      console.log('callback:', res);

      // res锛堢敤鎴蜂富鍔ㄥ叧闂獙璇佺爜锛?= {ret: 2, ticket: null}
      // res锛堥獙璇佹垚鍔燂級 = {ret: 0, ticket: "String", randstr: "String"}
      // res锛堣姹傞獙璇佺爜鍙戠敓閿欒锛岄獙璇佺爜鑷姩杩斿洖trerror_鍓嶇紑鐨勫鐏剧エ鎹級 = {ret: 0, ticket: "String", randstr: "String",  errorCode: Number, errorMessage: "String"}
      // 姝ゅ浠ｇ爜浠呬负楠岃瘉缁撴灉鐨勫睍绀虹ず渚嬶紝鐪熷疄涓氬姟鎺ュ叆锛屽缓璁熀浜巘icket鍜宔rrorCode鎯呭喌鍋氫笉鍚岀殑涓氬姟澶勭悊
      if (res.ret === 0) {
        // 澶嶅埗缁撴灉鑷冲壀鍒囨澘
        var str = '銆恟andstr銆?->銆?' + res.randstr + '銆?      銆恡icket銆?->銆?' + res.ticket + '銆?';
        var ipt = document.createElement('input');
        ipt.value = str;
        document.body.appendChild(ipt);
        ipt.select();
        document.execCommand('Copy');
        document.body.removeChild(ipt);
        alert('1. 杩斿洖缁撴灉锛坮andstr銆乼icket锛夊凡澶嶅埗鍒板壀鍒囨澘锛宑trl+v 鏌ョ湅銆?2. 鎵撳紑娴忚鍣ㄦ帶鍒跺彴锛屾煡鐪嬪畬鏁磋繑鍥炵粨鏋溿??');
      }
    }

    // 瀹氫箟楠岃瘉鐮乯s鍔犺浇閿欒澶勭悊鍑芥暟
    function loadErrorCallback() {
      var appid = '鎮ㄧ殑CaptchaAppId';
      // 鐢熸垚瀹圭伨绁ㄦ嵁鎴栬嚜琛屽仛鍏跺畠澶勭悊
      var ticket = 'trerror_1001_' + appid + '_' + Math.floor(new Date().getTime() / 1000);
      callback({
        ret: 0,
        randstr: '@' + Math.random().toString(36).substr(2),
        ticket: ticket,
        errorCode: 1001,
        errorMessage: 'jsload_error',
      });
    }

    // 瀹氫箟楠岃瘉鐮佽Е鍙戜簨浠?
    window.onload = function () {
      document.getElementById('CaptchaId').onclick = function () {
        try {
          // 鐢熸垚涓?涓獙璇佺爜瀵硅薄
          // CaptchaAppId锛氱櫥褰曢獙璇佺爜鎺у埗鍙帮紝浠庛?愰獙璇佺鐞嗐?戦〉闈㈣繘琛屾煡鐪嬨?傚鏋滄湭鍒涘缓杩囬獙璇侊紝璇峰厛鏂板缓楠岃瘉銆傛敞鎰忥細涓嶅彲浣跨敤瀹㈡埛绔被鍨嬩负灏忕▼搴忕殑CaptchaAppId锛屼細瀵艰嚧鏁版嵁缁熻閿欒銆?
          //callback锛氬畾涔夌殑鍥炶皟鍑芥暟
          var captcha = new TencentCaptcha('鎮ㄧ殑楠岃瘉鐮丆aptchaAppId', callback, {
            userLanguage: 'zh-cn',
            showFn: (ret) => {
              const {
                duration, // 楠岃瘉鐮佹覆鏌撳畬鎴愮殑鑰楁椂(ms)
                sid, // 閾捐矾sid
              } = ret;
            },
            verifyFn: (data) => {
              // 鏍￠獙缁撴灉+sid 鍥炶皟鍑芥暟
              const { pass, sid } = data;
              // pass: true 鏍￠獙閫氳繃, false 鏍￠獙鏈?氳繃
              // sid: 姝ゆ鏍￠獙鐨剆id
            },
          });
          // 璋冪敤鏂规硶锛屾樉绀洪獙璇佺爜
          captcha.show();
        } catch (error) {
          // 鍔犺浇寮傚父锛岃皟鐢ㄩ獙璇佺爜js鍔犺浇閿欒澶勭悊鍑芥暟
          loadErrorCallback();
        }
      };
    };
  </script>
</html>
```

## 鎺ュ叆璇存槑

### 姝ラ1锛氬姩鎬佸紩鍏ラ獙璇佺爜 JS

Web 椤甸潰闇?鍔ㄦ?佸紩鍏ラ獙璇佺爜 JS锛屽湪涓氬姟闇?瑕侀獙璇佹椂锛屽敜璧烽獙璇佺爜杩涜楠岃瘉銆?
``` bash
<!-- 鍔ㄦ?佸紩鍏ラ獙璇佺爜JS绀轰緥 -->
<script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
```

> **娉ㄦ剰**
> 

> 蹇呴』鍔ㄦ?佸紩鍏ラ獙璇佺爜 JS銆傚閫氳繃鍏朵粬鎵嬫瑙勯伩鍔ㄦ?佸姞杞斤紝浼氬鑷撮獙璇佺爜鏃犳硶姝ｅ父鏇存柊锛屽鎶楄兘鍔涙棤娉曚繚璇侊紝鐢氳嚦寮曡捣璇嫤鎴??
> 

> 濡傛灉浣跨敤楠岃瘉鐮?1.0锛岃灏? JS 鍦板潃鏀逛负 https://turing.captcha.qcloud.com/TCaptcha.js锛屽叾浠栨棤闇?鍙樻洿銆?
> 


### 姝ラ2锛氬垱寤洪獙璇佺爜瀵硅薄

寮曞叆楠岃瘉鐮? JS 鍚庯紝楠岃瘉鐮佷細鍦ㄥ叏灞?娉ㄥ唽涓?涓猔TencentCaptcha`绫伙紝涓氬姟鏂瑰彲浠ヤ娇鐢ㄨ繖涓被鑷鍒濆鍖栭獙璇佺爜锛屽苟瀵归獙璇佺爜杩涜鏄剧ず鎴栬?呴殣钘忋??

> **娉ㄦ剰**
> 

> 瑙﹀彂楠岃瘉鐮佺殑鍏冪礌涓嶈浣跨敤`id="TencentCaptcha"`锛孴encentCaptcha 灞炰簬绯荤粺榛樿 id锛岀敤鏉ュ吋瀹归獙璇佺爜鏃ф帴鍏ユ柟寮忋?? 
> 


#### 鏋勯?犲嚱鏁?
``` bash
new TencentCaptcha(CaptchaAppId, callback, options);
```

**鍙傛暟璇存槑**
<table>
<tr>
<td rowspan="1" colSpan="1" >鍙傛暟鍚?</td>

<td rowspan="1" colSpan="1" >鍊肩被鍨?</td>

<td rowspan="1" colSpan="1" >璇存槑</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >CaptchaAppId</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮? CaptchaAppId锛氱櫥褰? <a href="https://console.cloud.tencent.com/captcha/graphical">楠岃瘉鐮佹帶鍒跺彴</a>锛屽湪楠岃瘉绠＄悊椤甸潰杩涜鏌ョ湅銆傚鏋滄湭鍒涘缓杩囬獙璇侊紝璇峰厛鏂板缓楠岃瘉銆?<br>娉ㄦ剰锛氫笉鍙娇鐢ㄥ鎴风绫诲瀷涓哄皬绋嬪簭鐨? CaptchaAppId锛屼細瀵艰嚧鏁版嵁缁熻閿欒銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >callback</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮佸洖璋冨嚱鏁帮紝璇︽儏璇峰弬瑙? <a href="https://cloud.tencent.com/document/product/1110/36841#hdhs">callback 鍥炶皟鍑芥暟</a>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >options</td>

<td rowspan="1" colSpan="1" >Object</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮佸瑙傞厤缃弬鏁?, 璇︽儏璇峰弬瑙? <a href="https://cloud.tencent.com/document/product/1110/36841#pzcs">options 澶栬閰嶇疆鍙傛暟</a>銆?</td>
</tr>
</table>


#### callback 鍥炶皟鍑芥暟

楠岃瘉缁撴潫鍚庯紝浼氳皟鐢ㄤ笟鍔′紶鍏ョ殑鍥炶皟鍑芥暟锛屽苟鍦ㄧ涓?涓弬鏁颁腑浼犲叆鍥炶皟缁撴灉銆傚洖璋冪粨鏋滃瓧娈佃鏄庡涓嬶細
<table>
<tr>
<td rowspan="1" colSpan="1" >瀛楁鍚?</td>

<td rowspan="1" colSpan="1" >鍊肩被鍨?</td>

<td rowspan="1" colSpan="1" >璇存槑</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ret</td>

<td rowspan="1" colSpan="1" >Int</td>

<td rowspan="1" colSpan="1" >楠岃瘉缁撴灉锛?0锛氶獙璇佹垚鍔熴??2锛氱敤鎴蜂富鍔ㄥ叧闂獙璇佺爜銆?<br><strong>璇存槑锛?</strong><br>瀹圭伨鍦烘櫙涓嬮獙璇佺粨鏋滆繑鍥烇細0锛岃鎯呰鍙傝 <a href="https://cloud.tencent.com/document/product/1110/72310">涓氬姟瀹圭伨鏂规锛圵eb 鍙? App锛?</a>銆?<br></td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ticket</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >楠岃瘉鎴愬姛鐨勭エ鎹紝褰撲笖浠呭綋 ret = 0 鏃? ticket 鏈夊?笺??</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >appid</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮佸簲鐢? ID銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >bizState</td>

<td rowspan="1" colSpan="1" >Any</td>

<td rowspan="1" colSpan="1" >鑷畾涔夐?忎紶鍙傛暟銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >randstr</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >鏈楠岃瘉鐨勯殢鏈轰覆锛屽悗缁エ鎹牎楠屾椂闇?浼犻?掕鍙傛暟銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >errorCode</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >閿欒 code 锛岃鎯呰鍙傝 <a href="https://cloud.tencent.com/document/product/1110/36841#errorCode">鍥炶皟鍑芥暟 errorCode 璇存槑</a>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >errorMessage</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >閿欒淇℃伅銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >verifyDuration</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮佹牎楠屾帴鍙ｈ?楁椂锛坢s锛?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >actionDuration</td>

<td rowspan="1" colSpan="1" >Number</td>

<td rowspan="1" colSpan="1" >鐢ㄦ埛鎿嶄綔鏍￠獙鎴愬姛鑰楁椂锛坢s锛?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >sid</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >閾捐矾 sid</td>
</tr>
</table>




**鍥炶皟鍑芥暟 errorCode 璇存槑**

|errorCode|璇存槑|
|---------|---------|
|1001|TJCaptcha.js 鍔犺浇閿欒|
|1002|璋冪敤 show 鏂规硶瓒呮椂|
|1003|涓棿 JS 鍔犺浇瓒呮椂|
|1004|涓棿 JS 鍔犺浇閿欒|
|1005|涓棿 JS 杩愯閿欒|
|1006|鎷夊彇楠岃瘉鐮侀厤缃敊璇?/瓒呮椂锛堢綉缁滆秴鏃讹紝娆犺垂锛孋aptchaAppid 鍔犲瘑閰嶇疆閿欒锛墊
|1007|iframe 鍔犺浇瓒呮椂|
|1008|iframe 鍔犺浇閿欒|
|1009|jQuery 鍔犺浇閿欒|
|1010|婊戝潡 JS 鍔犺浇閿欒|
|1011|婊戝潡 JS 杩愯閿欒|
|1012|鍒锋柊杩炵画閿欒3娆
|1013|楠岃瘉缃戠粶杩炵画閿欒3娆
|1085|鏃犳劅楠岃瘉瓒呮椂/澶辫触|


#### options 澶栬閰嶇疆鍙傛暟

options 鍙傛暟鐢ㄤ簬瀵归獙璇佺爜杩涜瀹氬埗澶栬璁剧疆锛岄粯璁ゅ彲浠ヨ缃负绌恒??

> **娉ㄦ剰**
> 
> - 楠岃瘉鐮佸脊绐楀唴閮ㄤ笉鏀寔璋冩暣鏍峰紡澶у皬锛屽鏋滈渶瑕佽皟鏁达紝鍙湪寮圭獥鏈?澶栧眰鐢? class=tcaptcha-transform 鐨勫厓绱犺缃? transform:scale();锛堟洿鏀瑰ぇ灏忓彲鑳戒細瀵艰嚧楠岃瘉鐮佸浘鐗囧け鐪燂紝璇疯皑鎱庝慨鏀癸級銆備妇渚嬪涓嬶細
> `.tcaptcha-transform{
transform: scale(0.9);
}`
> - 楠岃瘉鐮佹湇鍔℃洿鏂板彲鑳戒細鏀瑰彉鍏冪礌鐨? id銆乧lass 绛夊睘鎬э紝璇峰嬁渚濊禆鍏朵粬楠岃瘉鐮佸厓绱犲睘鎬у?艰鐩栨牱寮忋??
> - 濡傛灉鎵嬫満鍘熺敓绔湁璁剧疆宸﹀彸婊戝姩鎵嬪娍锛岄渶鍦ㄨ皟鐢ㄩ獙璇佺爜 show 鏂规硶鍓嶇鐢紝楠岃瘉瀹屾垚鍚庡啀鎵撳紑锛岄槻姝笌楠岃瘉鐮佹粦鍔ㄤ簨浠跺啿绐併??

<table>
<tr>
<td rowspan="1" colSpan="1" >閰嶇疆鍚?</td>

<td rowspan="1" colSpan="1" >鍊肩被鍨?</td>

<td rowspan="1" colSpan="1" >璇存槑</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >bizState</td>

<td rowspan="1" colSpan="1" >Any</td>

<td rowspan="1" colSpan="1" >鑷畾涔夐?忎紶鍙傛暟锛屼笟鍔″彲鐢ㄨ瀛楁浼犻?掑皯閲忔暟鎹紝璇ュ瓧娈电殑鍐呭浼氳甯﹀叆 callback 鍥炶皟鐨勫璞′腑銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >enableDarkMode</td>

<td rowspan="1" colSpan="1" >Boolean\|String</td>

<td rowspan="1" colSpan="1" >寮?鍚嚜閫傚簲娣卞妯″紡鎴栧己鍒舵繁澶滄ā寮忋?傦紙<strong>VTT 绌洪棿璇箟楠岃瘉鏆備笉鏀寔璇ュ姛鑳?</strong>锛?<br>1. 寮?鍚嚜閫傚簲娣卞妯″紡: {"enableDarkMode": true}<br>2. 寮哄埗娣卞妯″紡: {"enableDarkMode": 'force'}</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >sdkOpts</td>

<td rowspan="1" colSpan="1" >Object</td>

<td rowspan="1" colSpan="1" >绀轰緥 {"width": 140, "height": 140}<br>浠呮敮鎸佺Щ鍔ㄧ鍘熺敓 webview 璋冪敤鏃朵紶鍏ワ紝鐢ㄦ潵璁剧疆楠岃瘉鐮? loading 鍔犺浇寮圭獥鐨勫ぇ灏忥紙<strong>娉ㄦ剰锛屽苟闈為獙璇佺爜寮圭獥澶у皬</strong>锛夈??</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >ready</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >楠岃瘉鐮佸姞杞藉畬鎴愮殑鍥炶皟锛屽洖璋冨弬鏁颁负楠岃瘉鐮佸疄闄呯殑瀹介珮锛堝崟浣嶏細px锛夛細<br>{"sdkView": {<br>"width": number,<br>"height": number<br>}}<br>璇ュ弬鏁颁粎涓烘煡鐪嬮獙璇佺爜瀹介珮浣跨敤锛?<strong>璇峰嬁浣跨敤姝ゅ弬鏁扮洿鎺ヨ瀹氬楂?</strong>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >needFeedBack</td>

<td rowspan="1" colSpan="1" >Boolean\|String</td>

<td rowspan="1" colSpan="1" >闅愯棌甯姪鎸夐挳鎴栬嚜瀹氫箟甯姪鎸夐挳閾炬帴銆傦紙<strong>VTT 绌洪棿璇箟楠岃瘉鏆備笉鏀寔鑷畾涔夐摼鎺?</strong>锛? <br>闅愯棌甯姪鎸夐挳: {"needFeedBack": false }<br>鑷畾涔夊府鍔╅摼鎺?: {"needFeedBack": 'url 鍦板潃' }</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >loading</td>

<td rowspan="1" colSpan="1" >Boolean</td>

<td rowspan="1" colSpan="1" >鏄惁鍦ㄩ獙璇佺爜鍔犺浇杩囩▼涓樉绀? loading 妗嗐?備笉鎸囧畾璇ュ弬鏁版椂锛岄粯璁ゆ樉绀? loading 妗嗐??<br>- 鏄剧ず loading 妗?: {"loading": true}<br>- 涓嶆樉绀? loading 妗?: {"loading": false} 锛堝睍绀烘柟寮忎负宓屽叆寮忔椂涓嶆敮鎸侀厤缃級</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >userLanguage</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >鎸囧畾楠岃瘉鐮佹彁绀烘枃妗堢殑璇█锛屼紭鍏堢骇楂樹簬鎺у埗鍙伴厤缃?傦紙<strong>VTT 绌洪棿璇箟銆佹枃瀛楃偣閫夐獙璇佹殏涓嶆敮鎸佽瑷?閰嶇疆</strong>锛?<br>鏀寔浼犲叆鍊煎悓 navigator.language 鐢ㄦ埛棣栭?夎瑷?锛屽ぇ灏忓啓涓嶆晱鎰熴??<br>璇︽儏鍙傝 <a href="https://cloud.tencent.com/document/product/1110/36841#userLanguage">userLanguage 閰嶇疆鍙傛暟</a>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >type</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >瀹氫箟楠岃瘉鐮佸睍绀烘柟寮忋??<br>- popup锛堥粯璁わ級寮瑰嚭寮忥紝浠ユ诞灞傚舰寮忓眳涓脊鍑哄睍绀洪獙璇佺爜銆?<br>- embed 宓屽叆寮忥紝浠ュ祵鍏ユ寚瀹氬鍣ㄥ厓绱犱腑鐨勬柟寮忓睍绀洪獙璇佺爜銆?<br>寮瑰嚭寮忓昂瀵?360*360锛屽綋瑙嗗浘灏忎簬涓?瀹氬楂橀獙璇佺爜鐨勮竟璺?30px 灏变細鑷姩缂╂斁銆傚祵鍏ュ紡灏哄300脳230 涓嶄細鏍规嵁灞忓箷澶у皬鑷姩缂╂斁銆傝鎯呭弬瑙? <a href="https://cloud.tencent.com/document/product/1110/36841#embed">宓屽叆寮忛獙璇佺爜鍙傛暟閰嶇疆绀轰緥</a>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >aidEncrypted</td>

<td rowspan="1" colSpan="1" >String</td>

<td rowspan="1" colSpan="1" >CaptchaAppId 鍔犲瘑鏍￠獙涓诧紝鍙?夊弬鏁般?傝鎯呰 <a href="https://cloud.tencent.com/document/product/1110/128489">楠岃瘉鐮? CaptchaAppid 閴存潈鍗囩骇鎸囧紩</a>銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >showFn</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >duration 娓叉煋鑰楁椂 + sid 鍥炶皟鍑芥暟銆?</td>
</tr>

<tr>
<td rowspan="1" colSpan="1" >verifyFn</td>

<td rowspan="1" colSpan="1" >Function</td>

<td rowspan="1" colSpan="1" >鐢ㄤ簬鑾峰彇姣忔楠岃瘉鏍￠獙鐨勭粨鏋滃拰 sid銆?<br>- pass锛坆oolean锛夛細鏈鏍￠獙缁撴灉锛宼rue 琛ㄧず楠岃瘉閫氳繃锛宖alse 琛ㄧず楠岃瘉鏈?氳繃銆?<br>- sid锛坰tring锛夛細鏈鏍￠獙鐨勪細璇? ID銆?</td>
</tr>
</table>




**宓屽叆寮忛獙璇佺爜鍙傛暟閰嶇疆绀轰緥**
``` java
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>楠岃瘉鐮?-鍐呭祵鎺ュ叆</title>
    <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
  </head>
  <body>
    <!-- 楠岃瘉鐮佹寚瀹氱殑鍐呭祵瀹瑰櫒 鍙嚜瀹氫箟鍒颁换浣曚綅缃? -->
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
          const captcha = new TencentCaptcha(document.getElementById('targetEmbed'), '鐢ㄦ埛CaptchaAppid', globalCallback, {
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



**userLanguage 閰嶇疆鍙傛暟锛?****闄ゆ粦鍔ㄦ嫾鍥鹃獙璇佸锛屽叾浠栭獙璇佸舰寮忓彧鏀寔涓嫳鏂囷級**

|鍙傛暟鍚峾璇存槑|
|---------|---------|
|zh-cn|绠?浣撲腑鏂噟
|zh-hk|绻佷綋涓枃锛堜腑鍥介娓級|
|zh-tw|绻佷綋涓枃锛堜腑鍥藉彴婀撅級|
|en|鑻辨枃|
|ar|闃挎媺浼|
|cs-cz|鎹峰厠璇紙鎹峰厠锛墊
|de|寰疯|
|en-in|鑻辫锛堝嵃搴︼級|
|es|瑗跨彮鐗欒|
|es-la|瑗跨彮鐗欒锛堟媺涓佺編娲诧級|
|fil|鑿插緥瀹捐|
|fr|娉曡|
|he|甯屼集鏉ヨ|
|hi|鍗板湴璇瓅
|id|鍗板凹璇瓅
|it|鎰忓ぇ鍒╄|
|ja|鏃ヨ|
|ko|鏈濋矞璇? / 闊╄|
|lo|鑰佹対璇瓅
|ms|椹潵璇瓅
|my|缂呯敻璇瓅
|nl|鑽峰叞璇瓅
|pl|娉㈠叞璇瓅
|pt|钁¤悇鐗欒|
|pt-pt|钁¤悇鐗欒锛堣憽钀勭墮锛墊
|ro-ro|缃楅┈灏间簹璇紙缃楅┈灏间簹锛墊
|ru|淇勮|
|th|娉拌|
|tr|鍦熻?冲叾璇瓅
|uk-ua|涔屽厠鍏拌锛堜箤鍏嬪叞锛墊
|ur|涔屽皵閮借|
|vi|瓒婂崡璇瓅


### 姝ラ3锛氳皟鐢ㄩ獙璇佺爜瀹炰緥鏂规硶

TencentCaptcha 鐨勫疄渚嬫彁渚涗竴浜涙搷浣滈獙璇佺爜鐨勫父鐢ㄦ柟娉曪細

|鏂规硶鍚峾璇存槑|浼犲叆鍙傛暟|杩斿洖鍐呭|
|---------|---------|---------|---------|
|show|鏄剧ず楠岃瘉鐮侊紝鍙互鍙嶅璋冪敤銆倈鏃爘鏃爘
|destroy|闅愯棌楠岃瘉鐮侊紝鍙互鍙嶅璋冪敤銆倈鏃爘鏃爘
|getTicket|鑾峰彇楠岃瘉鎴愬姛鍚庣殑 ticket銆倈鏃爘`Object:{"CaptchaAppId":"","ticket":""}`|


### 姝ラ4锛氬鐏惧鐞?

涓轰繚闅滈獙璇佺爜 Captcha 鏈嶅姟绔紓甯告椂涓嶉樆濉炲鎴风綉绔欐甯镐笟鍔℃祦绋嬶紝寤鸿鍙傝?冨涓嬫柟寮忔帴鍏ラ獙璇佺爜銆?
1. 瀹氫箟閿欒澶勭悊鍑芥暟銆?

   ``` javascript
   // 閿欒澶勭悊鍑芥暟浣滅敤锛氬湪鑴氭湰鍔犺浇鎴栧垵濮嬪寲閿欒鏃讹紝淇濋殰浜嬩欢娴佺▼姝ｅ父
   // 鍑芥暟瀹氫箟闇?鍦╯cript鍔犺浇鍓?
   function loadErrorCallback() {
    var appid = ''
    // 鐢熸垚瀹圭伨绁ㄦ嵁鎴栬嚜琛屽仛鍏跺畠澶勭悊
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
2. 楠岃瘉鐮佽繑鍥為敊璇椂锛岃皟鐢ㄩ敊璇鐞嗗嚱鏁般??

   ``` javascript
   try {
    // 鐢熸垚涓?涓獙璇佺爜瀵硅薄
    var captcha = new TencentCaptcha('鎮ㄧ殑楠岃瘉鐮丆aptchaAppId', callback, {});
    // 璋冪敤鏂规硶锛屾樉绀洪獙璇佺爜
    captcha.show(); 
   } catch (error) {
    // 鍔犺浇寮傚父锛岃皟鐢ㄩ獙璇佺爜js鍔犺浇閿欒澶勭悊鍑芥暟
    loadErrorCallback();
   }
   ```
3. 鍥炶皟鍑芥暟鏍规嵁 ticket 鍜? errorCode 锛堣?岄潪 ret锛夌殑鎯呭喌鍋氬鐞嗐??

   ``` javascript
   function callback(res) {
    // res锛堢敤鎴蜂富鍔ㄥ叧闂獙璇佺爜锛?= {ret: 2, ticket: null}
    // res锛堥獙璇佹垚鍔燂級 = {ret: 0, ticket: "String", randstr: "String"}
    // res锛堣姹傞敊璇紝杩斿洖trerror_鍓嶇紑鐨勫鐏剧エ鎹級 = {ret: 0, ticket: "String", randstr: "String",  errorCode: Number, errorMessage: "String"}
    if (res.ticket){
        //鏍规嵁errorCode鎯呭喌鍋氱壒娈婂鐞?
        if(res.errorCode === xxxxx){
           //鑷畾涔夊鐏鹃?昏緫锛堜緥濡傝烦杩囪繖娆￠獙璇侊級
        }
      }
   }
   ```

   瀹屾暣瀹圭伨鏂规锛岃鎯呰瑙乕涓氬姟瀹圭伨鏂规](https://cloud.tencent.com/document/product/1110/72310)銆?
   

   > **娉ㄦ剰**
   > 

   > 涓氬姟瀹㈡埛绔畬鎴愰獙璇佺爜鎺ュ叆鍚庯紝鏈嶅姟绔渶浜屾鏍告煡楠岃瘉鐮佺エ鎹粨鏋滐紙鏈帴鍏ョエ鎹牎楠岋紝浼氬鑷撮粦浜ц交鏄撲吉閫犻獙璇佺粨鏋滐紝澶卞幓楠岃瘉鐮佷汉鏈哄鎶楁晥鏋滐級锛岃鎯呰鍙傝锛歔鎺ュ叆绁ㄦ嵁鏍￠獙锛圵eb 鍙? App锛塢(https://cloud.tencent.com/document/product/1110/75489)銆?
   > 


### 姝ラ5锛欳aptchaAppid 閴存潈

CaptchaAppid 閴存潈閫氳繃鍓嶇浼犻?掑姞瀵嗙锛坅idEncrypted 鍙傛暟锛夛紝鍙湁鏁堥槻姝㈠洜 CaptchaAppid 娉勯湶瀵艰嚧鐨勮祫婧愮洍鍒烽闄┿?傝鎯呭弬瑙? [楠岃瘉鐮? CaptchaAppid 閴存潈鍗囩骇鎸囧紩](https://cloud.tencent.com/document/product/1110/128489)銆?

## React 鏋舵瀯鎺ュ叆绀轰緥
1. 鍦? HTML 妯℃澘鏂囦欢涓紩鍏ラ獙璇佺爜 JS銆?

   ``` html
   <!-- 楠岃瘉鐮佺▼搴忎緷璧?(蹇呴』)銆傝鍕夸慨鏀逛互涓嬬▼搴忎緷璧栵紝濡備娇鐢ㄦ湰鍦扮紦瀛橈紝鎴栭?氳繃鍏朵粬鎵嬫瑙勯伩鍔犺浇锛屼細瀵艰嚧楠岃瘉鐮佹棤娉曟甯告洿鏂帮紝瀵规姉鑳藉姏鏃犳硶淇濊瘉锛岀敋鑷冲紩璧疯鎷︽埅銆? -->
   <script src="https://turing.captcha.qcloud.com/TJCaptcha.js"></script>
   ```
2. 璋冪敤楠岃瘉鐮併??

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
     // 瀹氫箟鍥炶皟鍑芥暟
   
     function callback(res: ICaptchaResult) {
       // 绗竴涓弬鏁颁紶鍏ュ洖璋冪粨鏋滐紝缁撴灉濡備笅锛?
   
       // ret Int 楠岃瘉缁撴灉锛?0锛氶獙璇佹垚鍔熴??2锛氱敤鎴蜂富鍔ㄥ叧闂獙璇佺爜銆?
   
       // ticket String 楠岃瘉鎴愬姛鐨勭エ鎹紝褰撲笖浠呭綋 ret = 0 鏃? ticket 鏈夊?笺??
   
       // CaptchaAppId String 楠岃瘉鐮佸簲鐢↖D銆?
   
       // bizState Any 鑷畾涔夐?忎紶鍙傛暟銆?
   
       // randstr String 鏈楠岃瘉鐨勯殢鏈轰覆锛屽悗缁エ鎹牎楠屾椂闇?浼犻?掕鍙傛暟銆?
   
       console.log('callback:', res);
   
       // res锛堢敤鎴蜂富鍔ㄥ叧闂獙璇佺爜锛?= {ret: 2, ticket: null}
   
       // res锛堥獙璇佹垚鍔燂級 = {ret: 0, ticket: "String", randstr: "String"}
   
       // res锛堣姹傞獙璇佺爜鍙戠敓閿欒锛岄獙璇佺爜鑷姩杩斿洖trerror_鍓嶇紑鐨勫鐏剧エ鎹級 = {ret: 0, ticket: "String", randstr: "String", errorCode: Number, errorMessage: "String"}
   
       // 姝ゅ浠ｇ爜浠呬负楠岃瘉缁撴灉鐨勫睍绀虹ず渚嬶紝鐪熷疄涓氬姟鎺ュ叆锛屽缓璁熀浜巘icket鍜宔rrorCode鎯呭喌鍋氫笉鍚岀殑涓氬姟澶勭悊
   
       if (res.ret === 0) {
         // 澶嶅埗缁撴灉鑷冲壀鍒囨澘
   
         var str = '銆恟andstr銆?->銆?' + res.randstr + '銆? 銆恡icket銆?->銆?' + res.ticket + '銆?';
   
         var ipt = document.createElement('input');
   
         ipt.value = str;
   
         document.body.appendChild(ipt);
   
         ipt.select();
   
         document.execCommand('Copy');
   
         document.body.removeChild(ipt);
   
         alert('1. 杩斿洖缁撴灉锛坮andstr銆乼icket锛夊凡澶嶅埗鍒板壀鍒囨澘锛宑trl+v 鏌ョ湅銆? 2. 鎵撳紑娴忚鍣ㄦ帶鍒跺彴锛屾煡鐪嬪畬鏁磋繑鍥炵粨鏋溿??');
       }
     }
   
     // 瀹氫箟楠岃瘉鐮乯s鍔犺浇閿欒澶勭悊鍑芥暟
   
     function loadErrorCallback() {
       var appid = '鎮ㄧ殑CaptchaAppId';
   
       // 鐢熸垚瀹圭伨绁ㄦ嵁鎴栬嚜琛屽仛鍏跺畠澶勭悊
   
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
         // 鐢熸垚涓?涓獙璇佺爜瀵硅薄
   
         // CaptchaAppId锛氱櫥褰曢獙璇佺爜鎺у埗鍙帮紝浠庛?愰獙璇佺鐞嗐?戦〉闈㈣繘琛屾煡鐪嬨?傚鏋滄湭鍒涘缓杩囬獙璇侊紝璇峰厛鏂板缓楠岃瘉銆傛敞鎰忥細涓嶅彲浣跨敤瀹㈡埛绔被鍨嬩负灏忕▼搴忕殑CaptchaAppId锛屼細瀵艰嚧鏁版嵁缁熻閿欒銆?
   
         // callback锛氬畾涔夌殑鍥炶皟鍑芥暟
   
         const captcha = new TencentCaptcha('鎮ㄧ殑CaptchaAppId', callback, {});
   
         // 璋冪敤鏂规硶锛屾樉绀洪獙璇佺爜
   
         captcha.show();
       } catch (error) {
         // 鍔犺浇寮傚父锛岃皟鐢ㄩ獙璇佺爜js鍔犺浇閿欒澶勭悊鍑芥暟
   
         loadErrorCallback();
       }
     }
   
     return (
       <div className='App'>
         <button className='captcha-btn' onClick={onCaptchaShow}>
           寮瑰嚭楠岃瘉鐮?
         </button>
       </div>
     );
   }
   
   export default App;
   
   ```



## 甯歌闂

璇︽儏鍙傝 [鎺ュ叆鐩稿叧闂](https://cloud.tencent.com/document/product/1110/36828)銆?

## 鏇村淇℃伅

鎮ㄥ彲浠ョ櫥褰? [楠岃瘉鐮佹帶鍒跺彴](https://console.cloud.tencent.com/captcha/graphical)锛屽湪椤甸潰鍙充笅瑙掑崟鍑?**蹇?熷挩璇?**锛屼簡瑙ｆ洿澶氳缁嗕俊鎭??