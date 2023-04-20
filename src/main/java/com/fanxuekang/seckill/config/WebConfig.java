package com.fanxuekang.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Fan Xuekang
 * @time 2023年04月17日 16:48
 * @Description :  MVC配置类
 */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    /**     出现的问题：数据库中读入图片的访问地址之后，前端页面无法访问到图片，提示404 not funnd
     *      这个方法的功能：重新指定静态资源的访问路径。
     *
     * 约定大于配置：当项目中既有配置文件（application.yml）又有配置类（WebConfig）的情况下，那么优先级是配置类大于配置文件的，配置类优先加载，
     * 配置文件中mvc，  查找资源的路径是在static下，是没问题的，但是本配置类中，在没有重写addResourceHandlers方法前，是默认从当前目录下查找，
     * 所以解决方法就是重写addResourceHandlers方法，指定加载路径。
     *
     * 所以以上问题的解决方法：
     *      1、重写addResourceHandlers方法，指定加载路径
     *      2、把类前面的 @EnableWebMvc 注解删掉
     *      3、条当前路径下添加static路径，将图片文件放入
     * springboot的项目，他的资源就是放在static下面的，图片是放在static中，然后就可以直直接/img/iphone12.png就能找打
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//    }
}
