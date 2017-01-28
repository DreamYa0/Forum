package com.zbj.forum.web.interceptor;

import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.exception.ExceptionCode;
import com.zbj.forum.web.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author dreamyao
 *         Created by dreamyao on 2017/1/28.
 *         controller层异常处理切面
 */
public class ControllerExceptionHandler {

    // 对controller层类进行异常处理的方法
    public Object ExceptionHandling(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (CRUDException e) {
            result = new Result<>(e.getCode(), e.getMessage());
        } catch (Exception e) {
            result = new Result<>(ExceptionCode.SYSTEM_ERROR, "系统服务异常!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
