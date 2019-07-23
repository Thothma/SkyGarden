package com.baomidou.mybatisplus.samples.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Vector;

/**
 * @description:
 * @author: mafei2
 * @date: 2019-04-03 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestA {

    Vector list = new Vector(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));


    @Test
    public void threadUnSafe() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    getLast(list);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    deleteLast(list);
                }

            }
        });

        thread2.start();
        thread1.start();

    }

    @Test
    public  void test(){
        int i=0;
      while (true) {
          new TestA().threadUnSafe();
          System.out.println(i++);
      }
    }

    @Test
    public void threadSafe() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    getLastSafe(list);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9; i++) {
                    deleteLastSafe(list);
                }
            }
        });

        thread2.start();
        thread1.start();

    }


    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);

    }

    public static Object deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.remove(lastIndex);

    }

    public static Object getLastSafe(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }

    }

    public static Object deleteLastSafe(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.remove(lastIndex);
        }

    }
}
