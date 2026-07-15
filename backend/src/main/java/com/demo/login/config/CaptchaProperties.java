package com.demo.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯云滑动验证码配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    /** 是否开启后端票据校验（false=跳过，开发联调用；true=调用腾讯云API校验） */
    private boolean enabled = false;

    /** 验证码应用ID */
    private String captchaAppId;

    /** 验证码应用密钥 */
    private String appSecretKey;

    /** CAM访问密钥SecretId */
    private String secretId;

    /** CAM访问密钥SecretKey */
    private String secretKey;

    /** 腾讯云API地域 */
    private String region = "ap-guangzhou";
}