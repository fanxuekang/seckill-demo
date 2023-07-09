package com.fanxuekang.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author Fan Xuekang
 * @time 2023年03月29日 22:08
 * @Description :
 */
@Component
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final String salt = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);// 为了安全，这里做一个混淆，可有可无
        return md5(str);
    }

    public static String formToDBPass(String formPass,String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);// 为了安全，这里做一个混淆，可有可无
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt){
        String  formPass = inputPassToFormPass(inputPass);
        String dbPass = formToDBPass(formPass,salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}
