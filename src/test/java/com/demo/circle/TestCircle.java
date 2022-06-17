package com.demo.circle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        Integer result = anyNumberMultiplied(16);
        log.info("process on! result:{}", result);
    }

    /**
     * 任意数字的阶乘 0~15
     *
     * @return
     */
    public Integer anyNumberMultiplied(Integer number) {
        Integer resultNum = 1;
        if (number > 15) {
            return -1;
        }
        for (int i = 2; i <= number; i++) {
            resultNum = resultNum * i;
        }

        return resultNum;
    }
    /**
     * 输入任意值 计算它的阶乘 要求: 这个数 > 15 返回 -1
     *
     */


}
