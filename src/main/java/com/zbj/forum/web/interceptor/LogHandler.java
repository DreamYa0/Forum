package com.zbj.forum.web.interceptor;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;

/**
 * Created by dreamyao on 2017/1/28.
 */
public class LogHandler {

    public void log() {
        System.out.println();
        System.out.println();
        System.out.println("============================Log日志记录开始================================");
        System.out.println();
        System.out.println();
    }

    //有参无返回值的方法
    public void logArg(JoinPoint point) {
        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
        }
    }

    //有参并有返回值的方法
    public void logArgAndReturn(JoinPoint point, Object returnObj) {

        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println();
        System.out.println();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println("执行结果是：" + JSON.toJSONString(returnObj));
            System.out.println();
            System.out.println("=============================Log日志记录结束==================================");
            System.out.println();
            System.out.println();
        }
    }
}