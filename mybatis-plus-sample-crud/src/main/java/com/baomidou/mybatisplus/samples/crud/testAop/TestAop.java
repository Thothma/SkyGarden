package com.baomidou.mybatisplus.samples.crud.testAop;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TestAop {

    //日志
    Logger logger=LoggerFactory.getLogger(getClass());
    private RuntimeNode attributes;

    @Pointcut("execution(public * com.baomidou.mybatisplus.samples.crud.TestController.*(..))")
    public void log(){ }

    @Before("log()")
    public void doBefore(){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        logger.info("假装我在这里验证了用户身份");
        //url
        logger.info("url={}",request.getRequestURI());
        //方法
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        //logger.info("class_method={}",joinPoint.getSignature());
        //参数
        //logger.info("arg={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("假装我在这里处理最后的事情");
    }
}