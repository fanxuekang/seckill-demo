package com.fanxuekang.seckill.controller;

import com.fanxuekang.seckill.service.IUserService;
import com.fanxuekang.seckill.vo.LoginVO;
import com.fanxuekang.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Fan Xuekang
 * @time 2023年03月31日 18:44
 * @Description :
 */
//@RestController
@Controller  // 这里是做页面跳转，所以不用 restController，restController 会将返回值分装成对象返回
@RequestMapping("/login")
@Slf4j
public class LoginController {


    @Autowired
    private IUserService userService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录功能，log.info就是因为使用了sl4j
     * @param loginVO
     * @return
     */

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid  LoginVO loginVO, HttpServletRequest request,HttpServletResponse response){
        log.info("{}",loginVO);

        return userService.doLogin(loginVO,request,response);

    }
}
