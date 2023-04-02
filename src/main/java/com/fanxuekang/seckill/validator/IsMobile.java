package com.fanxuekang.seckill.validator;

import com.fanxuekang.seckill.vo.IsMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.List;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 16:27
 * @Description : 验证手机号
 */
// 开头的这些内容是从IsNull注解里面直接复制过来的
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint( validatedBy = {IsMobileValidator.class})
public @interface IsMobile {
    boolean required() default true;

    String message() default "@IsMobile中：手机号码格式错误";  // 报错信息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
