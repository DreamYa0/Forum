package com.zbj.forum.utils;

import com.alibaba.fastjson.JSON;
import com.zbj.forum.service.IUserService;

/**
 * @author dreamyao
 * Created by dreamyao on 2017/1/30.
 * 注入AspectJ切面,Demo
 */
public aspect AspectJTest {

    /**
     * 可以利用Spring依赖注入功能，
     * 为切面注入Bean
     */
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public AspectJTest(){}

    /**
     * 创建切点
     */
    pointcut dreamyao():execution(* com.zbj.forum.web.controller..*.*(..));
    /**
     * 创建后置通知
     */
    after():dreamyao(){
        JSON.toJSONString(userService.getAllUsers());
    }
}
