# 登录注册 Demo（Vue 3 + Spring Boot）

简单的前后端分离登录注册示例，账号密码明文存入 MySQL，集成腾讯云滑动验证码。

## 技术栈

- 后端：Spring Boot 3.2.5 + Spring Data JPA + MySQL + 腾讯云验证码 SDK
- 前端：Vue 3 + Vite + Vue Router + Axios

## 目录结构

`
Slider_Verification/
├── backend/        Spring Boot 后端
│   ├── pom.xml
│   └── src/main/...
├── frontend/       Vue 3 前端
│   ├── package.json
│   └── src/...
└── README.md
`

## 数据库配置

后端连接 MySQL（见 ackend/src/main/resources/application.yml）：

- 地址：`127.0.0.1:3306`（本机 MySQL）
- 数据库名：`login_demo`（启动时自动创建）
- 用户名：`root`
- 密码：`12345`


> `sql
> CREATE USER 'root'@'%' IDENTIFIED BY '12345';
> GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
> FLUSH PRIVILEGES;
> `

表 `users` 由 JPA（`ddl-auto=update`）自动创建，无需手动建表。

## 腾讯云滑动验证码配置

登录注册页面集成了腾讯云滑动验证码（前端弹滑块 → 后端校验票据），采用**前端默认生效、后端票据校验默认关闭可一键开启**的设计，开发即用、生产再开。

### 1. 前端配置

编辑 `frontend/src/captcha.js`，填入你的 CaptchaAppId：

`js
export const CAPTCHA_APP_ID = '你的CaptchaAppId'
`

> CaptchaAppId 在 [验证码控制台](https://console.cloud.tencent.com/captcha) → 验证管理 → 基础配置 获取。
> **注意：必须使用 Web 客户端类型的 CaptchaAppId**，不能用小程序类型的。

### 2. 后端配置

编辑 `backend/src/main/resources/application.yml` 的 `captcha` 段：

`yaml
captcha:
  enabled: false               # false=跳过后端校验（开发联调用），true=调用腾讯云API校验
  captcha-app-id: 你的CaptchaAppId    # 验证码控制台获取
  app-secret-key: 你的AppSecretKey     # 验证码控制台获取
  secret-id: 你的SecretId              # CAM 访问管理 → API密钥管理
  secret-key: 你的SecretKey            # 同上
  region: ap-guangzhou
`

| 参数 | 说明 | 获取位置 |
|------|------|----------|
| `captcha-app-id` | 验证码应用ID | 验证码控制台 → 验证管理 → 基础配置 |
| `app-secret-key` | 验证码应用密钥 | 同上 |
| `secret-id` | CAM访问密钥ID | [访问管理 → API密钥管理](https://console.cloud.tencent.com/cam/capi) |
| `secret-key` | CAM访问密钥 | 同上 |
| `enabled` | 后端票据校验开关 | 开发时 `false`，生产时 `true` |

### 3. 校验流程

1. 用户点击登录/注册按钮
2. 前端弹出滑块验证（`TJCaptcha.js`）
3. 滑块通过后前端拿到 `ticket` + `randstr`
4. 前端将 `ticket`/`randstr` 随账号密码一起发给后端
5. 后端（`enabled=true` 时）调用腾讯云 `DescribeCaptchaResult` API 二次校验票据
6. 校验通过才执行注册/登录逻辑

> **`enabled=false` 时**：后端跳过票据校验直接放行，方便开发联调（此时前端滑块仍会弹出，但后端不验证票据真伪）。

## 启动后端

`ash
cd backend
mvn spring-boot:run
`

后端运行在 http://localhost:8080，提供接口：

- `POST /api/user/register`  body：`{ "username": "xxx", "password": "xxx", "ticket": "xxx", "randstr": "xxx" }`
- `POST /api/user/login`      body：`{ "username": "xxx", "password": "xxx", "ticket": "xxx", "randstr": "xxx" }`

> `ticket`/`randstr` 由前端滑块验证成功后自动生成并提交。

## 启动前端

`ash
cd frontend
npm install
npm run dev
`

前端运行在 http://localhost:5173，已通过 Vite 代理 `/api` 到后端 8080。

## 使用流程

1. 确保 MySQL 已启动
2. 在 [验证码控制台](https://console.cloud.tencent.com/captcha) 新建验证，拿到 CaptchaAppId 和 AppSecretKey。
3. 在 [CAM 密钥管理](https://console.cloud.tencent.com/cam/capi) 拿到 SecretId 和 SecretKey。
4. 填入 `frontend/src/captcha.js` 和 `backend/src/main/resources/application.yml`。
5. 启动后端：`cd backend && mvn spring-boot:run`。
6. 启动前端：`cd frontend && npm install && npm run dev`。
7. 浏览器打开 http://localhost:5173/register 注册账号。
8. 注册成功后跳转登录页，登录成功进入首页。
