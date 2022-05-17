package com.example.springrediscachedemo.util;

/**
 * rate limiter type:
 * DEFAULT: 根据接口限流，比如某个接口1分钟之类访问100次
 * IP: 根据IP地址来限流，比如某个IP地址1分钟之内访问100次
 */
public enum LimitType {
    DEFAULT,IP
}
