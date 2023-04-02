package com.fanxuekang.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanxuekang.seckill.exception.GlobalException;
import com.fanxuekang.seckill.mapper.UserMapper;
import com.fanxuekang.seckill.pojo.User;
import com.fanxuekang.seckill.service.IUserService;
import com.fanxuekang.seckill.utils.CookieUtil;
import com.fanxuekang.seckill.utils.MD5Util;
import com.fanxuekang.seckill.utils.UUIDUtil;
import com.fanxuekang.seckill.utils.ValidatorUtil;
import com.fanxuekang.seckill.vo.LoginVO;
import com.fanxuekang.seckill.vo.RespBean;
import com.fanxuekang.seckill.vo.RespBeanEnum;
import com.mysql.cj.util.StringUtils;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fanxuekang
 * @since 2023-03-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper ;
    @Override
    public RespBean doLogin(LoginVO loginVO, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVO.getMobile();
        String pass = loginVO.getPassword();
        // 参数校验过程，已经用了自定义注解实现了，这里就屏蔽了
//        if(StringUtils.isNullOrEmpty(mobile)||StringUtils.isNullOrEmpty(pass)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);  // 这里实际运行的时候应该会有状态码好信息不对的问题，
//            // 因为eoor这个方法内容都是选择ERROR这个对象
//        }
//        if(!ValidatorUtil.isMobile(mobile)){
//            System.out.println(mobile);
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }

        User user = userMapper.selectById(mobile);
        // 差找不到用户就是有问题
        if(null == user){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        // 判断密码是否正确
        if(!(MD5Util.formToDBPass(pass,user.getSalt()).equals(user.getPassword()))){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 走到这里就是允许成功登录了，这里要设置cookie，方便后面能够每次查询和提交秒杀的时候，能够不需要重新登陆
        // 生成cookie
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();

    }
}
