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

    public static List<String> puCartList = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "j", "q", "k", "小王", "大王");

    public static String puCartNumber(String puCard) {
        //puCard = puCard.toLowerCase();
        // contains 包含方法 一个对象如果包含在这个集合里返回true否则返回false
        if (puCartList.contains(puCard)) {
            return String.valueOf(puCartList.indexOf(puCard) + 1);
        } else {
            return "非法输入";
        }
    }
}
