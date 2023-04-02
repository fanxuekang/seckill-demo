package com.fanxuekang.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fan Xuekang
 * @time 2023年03月29日 17:32
 * @Description : 测试
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
//    测试页面跳转
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","fanxuekang");
        return "hello";
    }
}
