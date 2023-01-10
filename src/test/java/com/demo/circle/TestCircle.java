package com.demo.circle;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: mafei
 * @Date: 2022/6/11 9:00 PM
 * @Description: 测试循环类
 **/
@Slf4j
public class TestCircle {

    @Test
    public void testCircleMain() {
        for (int j = 1; j < 10; j++) {
            for (int i = 1; i < 10; i++) {
                if (j == 5) {
                    break;
                }
                log.info("{} * {} = {}", i, j, i * j);
            }
            if (j == 5) {
                break;
            }
        }

        log.info("xxx");
    }


    /**
     * 输出10的阶乘
     */
    @Test
    public void testCircleMain2() {
        Integer result = anyNumberMultiplied(1);
        log.info("process on! request:{}, result:{}", 1, result);
        Integer result2 = anyNumberMultiplied(15);
        log.info("process on! request:{}, result:{}", 15, result2);
        Integer result3 = anyNumberMultiplied(3);
        log.info("process on! request:{}, result:{}", 3, result3);
        Integer result4 = anyNumberMultiplied(1000);
        log.info("process on! request:{}, result:{}", 1000, result4);
        Integer result5 = anyNumberMultiplied(null);
        log.info("process on! request:{}, result:{}", null, result5);
        Integer result6 = anyNumberMultiplied(-100);
        log.info("process on! request:{}, result:{}", -100, result6);

    }

    /**
     * 任意数字的阶乘 1~15
     * 输入任意值 计算它的阶乘 要求: 1～15  否则返回 -1
     *
     * @return
     */
    public Integer anyNumberMultiplied(Integer number) {
        Integer resultNum = 1;
        // 程序最主要的是注意边界值、异常值的处理
        if (number == null || number < 1 || number > 15) {
            return -1;
        }
        for (int i = 2; i <= number; i++) {
            resultNum = resultNum * i;
        }

        return resultNum;
    }

    public static List<String> puCartList = Lists.newArrayList("1" /*0*/, "2", "3", "4", "5", "6", "7" /*6*/, "8", "9", "10",
            "j", "q", "k", "小王", "大王");

    public static String puCartNumberV2(String puCard) {
        //puCard = puCard.toLowerCase();
        // contains 包含方法 一个对象如果包含在这个集合里返回true否则返回false
        if (puCartList.contains(puCard)) {
            return String.valueOf(puCartList.indexOf(puCard) + 1);
        } else {
            return "非法输入";
        }
    }

    public static String puCartNumber(String puCard) {

        int val = puCartList.indexOf(puCard);
        if (val == -1) {
            return "非法输入";
        } else {
            return String.valueOf(val + 1);
        }
    }

    public static String sayColor(String color) {

        if (color.equals("蓝色")) {
            return "绿色";
        }
        if (color.equals("绿色")) {
            return "蓝色";
        }

        return color;
    }

    public static String sayColor2(String color) {

        String result = color;
        if (color.equals("蓝色")) {
            result = "绿色";
        }
        if (color.equals("绿色")) {
            result = "蓝色";
        }

        return result;
    }

    public static String sayColor3(String color) {

        String result = color;
        if (color.equals("蓝色")) {
            result = "绿色";
        } else if (color.equals("绿色")) {
            result = "蓝色";
        }

        return result;
    }

    @Test
    public void testSayColor() {
        log.error(sayColor3("蓝色"));
    }


    public static int multiply(int a, int b) {
        if (a == 3 && b == 4) {
            return 16;
        }

        if (a == 4 && b == 3) {
            return 16;
        }

        return a * b;
    }

    @Test
    public void testMultiply() {
        log.error(String.valueOf(multiply(3, 4)));
        log.error(String.valueOf(multiply(4, 3)));
        log.error(String.valueOf(multiply(4, 4)));
        log.error(String.valueOf(multiply(5, 5)));
    }

    public int getGCD(int a, int b) {
        // 获取两数中的小数
        int minValue = a > b ? b : a;
        // 3 6   3 32 4 16
        // 开始递增循环 循环到较小数的本身 穷举法
        int result = 1;
        for (int i = 2; i <= minValue; i++) {
            // % 求余数运算符
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }

    @Test
    public void testGetGCD() {
        log.error(String.valueOf(getGCD(9, 1)));
        log.error(String.valueOf(getGCD(9, 4)));
        log.error(String.valueOf(getGCD(9, 6)));
        log.error(String.valueOf(getGCD(7, 49)));
        log.error(String.valueOf(getGCD(12, 16)));
    }

    public void outputOdd(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                log.info(String.valueOf(i));
            }
        }
    }

    @Test
    public void testOutputOdd() {
        outputOdd(99);

    }

    public void outputEven(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                continue;
            }
            log.info(String.valueOf(i));
        }
    }

    @Test
    public void testOutputEven() {
        outputEven(99);
    }


}
