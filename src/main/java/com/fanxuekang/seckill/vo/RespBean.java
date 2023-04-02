package com.fanxuekang.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fan Xuekang
 * @time 2023年03月31日 21:17
 * @Description : 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private Integer code;
    private String message;
    private Object object;

    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),null);
    }


    public static RespBean success(Object object){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),object);
    }


    public static RespBean error(){
        return new RespBean(RespBeanEnum.ERROR.getCode(),RespBeanEnum.ERROR.getMessage(),null);
    }
    public static RespBean error(Object o){
        return new RespBean(RespBeanEnum.ERROR.getCode(),RespBeanEnum.ERROR.getMessage(),o);
    }

    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }

}
