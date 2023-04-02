package com.fanxuekang.seckill.utils;

import java.util.UUID;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 22:12
 * @Description :
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
