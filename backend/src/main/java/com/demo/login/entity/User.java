package com.demo.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    /** 验证码票据（不落库，仅用于接收前端参数） */
    @Transient
    private String ticket;

    /** 验证码随机串（不落库，仅用于接收前端参数） */
    @Transient
    private String randstr;
}