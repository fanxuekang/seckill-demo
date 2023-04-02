package com.fanxuekang.seckill.exception;

import com.fanxuekang.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 21:41
 * @Description : 全局异常
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;

}
