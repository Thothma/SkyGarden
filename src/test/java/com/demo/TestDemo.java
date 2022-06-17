package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @Author: mafei
 * @Date: 2022/6/9 9:56 PM
 * @Description: 测试演示类
 **/
@Slf4j
public class TestDemo {

    String name;

    @Test
    public void test1() {
        String name2 = "123";
        log.info("hello world!");
    }

    @Test
    public void test2() {
       test1();
        log.info("hello world, again!");
    }


    @Test
    public void testForOptionMain() {
      testForOption(true);
      test2();
      testForOption(null); // this
      testForOption(false);
    }

    public void testForOption(Boolean goHomeFlag) {
        if (goHomeFlag == null) {
            log.info("输入不合法！"); // 2
            return;
        }
        if (goHomeFlag) {
            log.info("你今天回家了 那么我就和同事聚餐 晚上一个人过"); // 1
        } else {
            log.info("你今天不回家 那么我们就一起吃饭、看电影，一起过"); // 3
        }
    }

    /**
     * 张婷小姐姐的完美测试方法
     */
    @Test
    public void testReadAnimals() {
        readAnimals("兔");
        readAnimals("猫");
        readAnimals("狗");
        readAnimals("啥也不是");
        readAnimals(null);
    }


    /**
     * 研发小马写的垃圾方法 读取动物方法
     *
     * @param animals
     */
    public void readAnimals(String animals) {
        if (animals == null) {
            log.info("输入不合法！");
            return;
        }
        if (animals.equals("猫")) {
            log.info("这是一只猫!");
        } else if (animals.equals("狗")) {
            log.info("这是一只狗!");
        } else if (animals.equals("兔")) {
            log.info("这是一只兔!");
        } else {
            log.info("未知动物");
        }
    }



}
