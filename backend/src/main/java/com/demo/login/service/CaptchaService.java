package com.demo.login.service;

import com.demo.login.config.CaptchaProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.captcha.v20190722.CaptchaClient;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultRequest;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 腾讯云滑动验证码票据校验服务
 * <p>
 * 前端滑块验证成功后会返回 ticket + randstr，后端调用腾讯云
 * DescribeCaptchaResult 接口进行二次校验，防止票据被伪造。
 * <p>
 * 当 captcha.enabled = false 时跳过校验（开发联调用），
 * 设为 true 后才会真正调用腾讯云API（生产环境建议开启）。
 */
@Slf4j
@Service
public class CaptchaService {

    @Autowired
    private CaptchaProperties captchaProperties;

    /**
     * 校验滑动验证码票据
     *
     * @param ticket  前端返回的验证票据
     * @param randstr 前端返回的随机串
     * @param userIp  客户端真实IP
     * @return true=验证通过（或未开启后端校验）；false=验证失败
     */
    public boolean verify(String ticket, String randstr, String userIp) {
        // 未开启后端校验，直接放行（开发联调阶段）
        if (!captchaProperties.isEnabled()) {
            log.debug("后端票据校验未开启，跳过校验");
            return true;
        }
        // 票据参数为空，直接拒绝
        if (ticket == null || ticket.isBlank() || randstr == null || randstr.isBlank()) {
            return false;
        }
        try {
            // 构建CAM凭证
            Credential cred = new Credential(
                    captchaProperties.getSecretId(),
                    captchaProperties.getSecretKey()
            );
            // 构建客户端配置
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("captcha.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            CaptchaClient client = new CaptchaClient(
                    cred, captchaProperties.getRegion(), clientProfile
            );
            // 组装请求参数
            DescribeCaptchaResultRequest req = new DescribeCaptchaResultRequest();
            req.setCaptchaType(9L);              // 固定值：滑动验证2.0
            req.setTicket(ticket);
            req.setRandstr(randstr);
            req.setUserIp(userIp);
            req.setCaptchaAppId(Long.parseLong(captchaProperties.getCaptchaAppId()));
            req.setAppSecretKey(captchaProperties.getAppSecretKey());
            // 发起校验
            DescribeCaptchaResultResponse resp = client.DescribeCaptchaResult(req);
            // CaptchaCode = 1 表示验证通过
            boolean ok = resp.getCaptchaCode() != null && resp.getCaptchaCode() == 1L;
            if (!ok) {
                log.warn("验证码校验失败: code={}, msg={}",
                        resp.getCaptchaCode(), resp.getCaptchaMsg());
            }
            return ok;
        } catch (Exception e) {
            log.error("验证码票据校验异常", e);
            return false;
        }
    }
}