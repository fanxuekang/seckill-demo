package com.fanxuekang.seckill.vo;

import com.fanxuekang.seckill.utils.ValidatorUtil;
import com.fanxuekang.seckill.validator.IsMobile;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 16:31
 * @Description : 手机号码校验规则类，用于自定义的@IsMobile注解中
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required(); // 设置是否是必填项
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required){  // 如果是必填项，那就检查是否符合电话的格式要求
            return ValidatorUtil.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true; // 既然是非必填项了，那么空也就是符合条件了 true
            }else{
                return ValidatorUtil.isMobile(value);  // 有内容就验证是否是手机号
            }
        }

    }
}
