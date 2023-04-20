package com.fanxuekang.seckill.controller;

import com.fanxuekang.seckill.pojo.User;
import com.fanxuekang.seckill.service.IGoodsService;
import com.fanxuekang.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Fan Xuekang
 * @time 2023年04月01日 22:56
 * @Description :
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;
    /**
     * 功能：跳转到商品列表页面
     * @param session
     * @param model
     * @param ticket
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model,User user){
//        if(StringUtils.isEmpty(ticket)){
//            return "login";
//        }
////        不再通过session获取用户信息，而是用过redis获取
////        User user = (User) session.getAttribute(ticket);
//        //
//        User user = userService.getUserByCookie(ticket, request, response);
//        if(null == user){
//            return "login";
//        }
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVO());
        return "goodsList";
    }
}
