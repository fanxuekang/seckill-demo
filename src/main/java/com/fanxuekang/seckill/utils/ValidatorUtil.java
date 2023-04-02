package com.fanxuekang.seckill.utils;

import com.mysql.cj.util.StringUtils;
import com.sun.istack.internal.FinalArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 11:34
 * @Description :  手机号码校验
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    public static boolean isMobile(String mobile){
        if(StringUtils.isNullOrEmpty(mobile)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }

    public static void main(String[] args) {
//        String mobile = "111111111";
        String mobile = "18865382179";
        System.out.println(isMobile(mobile));
    }
}
