package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author: mafei
 * @Date: 2022/6/13 5:15 PM
 * @Description:
 **/
@Slf4j
public class TestLogWarn {


    @Test
    public void testWarnFunction() {
        try {
            String s = null;
            log.info(s.toString());
        } catch (Exception e) {
            log.warn("testWarnFunction :{}", "xxx", e);
        }

    }
}
