package com.baomidou.mybatisplus.samples.quickstart.entity;



/**
 * @description:
 * @author: mafei2
 * @date: 2019-04-03 9:35
 */
public class UnsafeSequence {
      private   int value;

    public synchronized int getNext(){
        return value++;
    }
}
