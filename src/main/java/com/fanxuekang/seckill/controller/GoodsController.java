package com.fanxuekang.seckill.controller;

import com.fanxuekang.seckill.pojo.User;
import com.fanxuekang.seckill.service.IGoodsService;
import com.fanxuekang.seckill.service.IUserService;
import com.fanxuekang.seckill.vo.GoodsVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

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

    /**
     * 跳转商品详情页
     * @param goodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model  model,User user, @PathVariable Long goodsId){
        model.addAttribute("user",user);
        GoodsVO goodsVO = goodsService.findGoodsVOByGoodsId(goodsId);
        Date startDate = goodsVO.getStartDate();
        Date endDate = goodsVO.getEndDate();
        Date nowDate = new Date();
        int secKillStatus = 0;
        int remainSeconds = 0;
        if(nowDate.before(startDate)){  // 秒杀还没开始
            remainSeconds = (int)((startDate.getTime()-nowDate.getTime())/1000);
        }else if(nowDate.after(endDate)){ // 已结束
            secKillStatus = 2;
            remainSeconds = -1;
        }else{  // 进行中
            secKillStatus = 1;
            remainSeconds = 0;
        }
        System.out.println(secKillStatus);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("goods",goodsVO);
        return "goodsDetail";
    }


}
