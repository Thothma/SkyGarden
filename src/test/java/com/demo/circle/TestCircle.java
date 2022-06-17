package com.demo.circle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author: mafei
 * @Date: 2022/6/11 9:00 PM
 * @Description: 测试循环类
 **/
@Slf4j
public class TestCircle {
    public static void main(String[] args) {
        System.out.println("xxx");
    }
    @Test
    public void testCircleMain() {
        for (int j = 1; j < 10; j++) {
            for (int i = 1; i < 10; i++) {
                if ( j == 5) {
                    break;
                }
                log.info("{} * {} = {}", i, j, i * j);
            }
            if ( j == 5) {
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
        int i = 1;
        for (int j = 1; j < 10; j++) {
          i = i * j;
        }

        log.info("10的阶乘：{}",i);
    }
}
