// 腾讯云验证码配置
// CaptchaAppId 从 frontend/.env 读取（该文件不提交）
// 克隆项目后复制 .env.example 为 .env 并填入你的 CaptchaAppId
const CAPTCHA_APP_ID = import.meta.env.VITE_CAPTCHA_APP_ID || '你的CaptchaAppId'

/**
 * 弹出滑块验证
 * 成功返回 { ticket, randstr }，用户关闭或失败时 reject
 */
export function showCaptcha() {
  return new Promise((resolve, reject) => {
    if (typeof window.TencentCaptcha !== 'function') {
      reject(new Error('验证码脚本未加载，请检查网络'))
      return
    }
    try {
      const captcha = new window.TencentCaptcha(CAPTCHA_APP_ID, (res) => {
        if (res.ret === 0 && res.ticket && res.randstr) {
          resolve({ ticket: res.ticket, randstr: res.randstr })
        } else {
          reject(new Error('用户未完成滑块验证'))
        }
      }, {})
      captcha.show()
    } catch (e) {
      reject(e)
    }
  })
}