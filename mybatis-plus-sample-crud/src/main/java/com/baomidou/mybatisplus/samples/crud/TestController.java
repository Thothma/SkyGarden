package com.baomidou.mybatisplus.samples.crud;

import com.baomidou.mybatisplus.samples.crud.log.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.zip.GZIPOutputStream;

/**
 * @description:
 * @author: mafei2
 * @date: 2019-03-28 17:46
 */
@Controller
@RequestMapping("/test1")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping("/test2")
    public Integer test(String s){
        try {

            return null;
        }catch (Exception e){
          logger.error(e.getMessage());
        }

        return null;
    }


    @RequestMapping(value = "/push", method = {RequestMethod.GET})
    @SysLog
    public void chimelong(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 返回结果
        try{
            int a=3/0;
        }catch (Exception e){
            logger.info("123",123);

        }

    }
}
