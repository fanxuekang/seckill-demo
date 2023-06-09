package com.fanxuekang.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Fan Xuekang
 * @time 2023年03月31日 21:12
 * @Description : 公共返回对象的枚举
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //返回信息
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端错误了"),

    //登录模块
    LOGIN_ERROR(500210,"用户名或密码不正确"),
    MOBILE_ERROR(500211,"手机号码格式不正确"),
    BIND_ERROR(500212,"参数校验异常")



    ;


    private final Integer code;
    private final String message;

}
