package com.fanxuekang.seckill.vo;

import com.fanxuekang.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Fan Xuekang
 * @time 2023年03月31日 21:57
 * @Description :
 */
@Data
public class LoginVO {
    @NotNull
    @IsMobile(required = true)
    private String mobile;
    @NotBlank
    @Length(min = 32)
    private String password;
}
