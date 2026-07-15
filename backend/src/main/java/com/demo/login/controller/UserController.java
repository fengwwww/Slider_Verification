package com.demo.login.controller;

import com.demo.login.common.Result;
import com.demo.login.entity.User;
import com.demo.login.service.CaptchaService;
import com.demo.login.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpServletRequest request) {
        // 先校验滑动验证码票据
        if (!captchaService.verify(user.getTicket(), user.getRandstr(), getClientIp(request))) {
            return Result.error(403, "滑块验证未通过，请重试");
        }
        boolean ok = userService.register(user);
        return ok ? Result.success("注册成功") : Result.error(400, "用户名已存在");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        // 先校验滑动验证码票据
        if (!captchaService.verify(user.getTicket(), user.getRandstr(), getClientIp(request))) {
            return Result.error(403, "滑块验证未通过，请重试");
        }
        boolean ok = userService.login(user);
        return ok ? Result.success("登录成功") : Result.error(400, "用户名或密码错误");
    }

    /**
     * 获取客户端真实IP（兼容多级代理）
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多级代理时取第一个IP
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}