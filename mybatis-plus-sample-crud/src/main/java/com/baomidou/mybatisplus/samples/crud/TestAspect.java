package com.baomidou.mybatisplus.samples.crud;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: mafei2
 * @date: 2019-07-20 10:46
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.baomidou.mybatisplus.samples.crud.TestController.*(..))")
    public void exc(){
        System.out.println("before before");
    }

    @Pointcut("execution(public * com.baomidou.mybatisplus.samples.crud.TestController.test(..))")
    public void log(){
        System.out.println("before before");
    }

    @Before("exc()")
    public void doBefore(){
        System.out.println("do before");
    }


    @Before("log()")
    public void doBefore2(){
        System.out.println("do before2");
    }
}
