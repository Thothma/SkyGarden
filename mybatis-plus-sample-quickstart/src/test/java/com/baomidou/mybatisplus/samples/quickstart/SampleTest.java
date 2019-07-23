package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.samples.quickstart.entity.UnsafeSequence;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    UnsafeSequence unsafeSequence=new UnsafeSequence();;

    Vector list=new Vector(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
        System.out.println(userList);
    }
    @Test
    public void threadTest() {
      Thread thread1=new Thread(new Runnable() {
          @Override
          public void run() {
              for (int i = 0; i <5 ; i++) {
                  getLast(list);
              }
          }
      });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    deleteLast(list);
                }

            }
        });

        thread2.start();
        thread1.start();

    }



    public static  Object getLast(Vector list){
        int lastIndex=list.size()-1;
        return list.get(lastIndex);

    }

    public static  Object deleteLast(Vector list){
        int lastIndex=list.size()-1;
        return list.remove(lastIndex);

    }


    class RunnableA implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5000; i++) {
                System.out.println(Thread.currentThread().getName()+"  :  "+unsafeSequence.getNext());
            }
        }
    }
}
