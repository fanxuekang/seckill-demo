package com.fanxuekang.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanxuekang.seckill.pojo.User;
import com.fanxuekang.seckill.vo.LoginVO;
import com.fanxuekang.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fanxuekang
 * @since 2023-03-31
 */
public interface IUserService extends IService<User> {

    public RespBean doLogin(LoginVO loginVO, HttpServletRequest request, HttpServletResponse response);


    /**
     * 根据cookie获取用户
     * @param userTicket
     * @return
     */
    User getUserByCookie(String userTicket, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
