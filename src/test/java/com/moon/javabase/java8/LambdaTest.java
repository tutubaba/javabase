package com.moon.javabase.java8;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class LambdaTest {
    private Log LOG = LogFactory.getLog(LambdaTest.class);

    @Test
    public void test1() {
        // 无参数
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };

        Runnable runnable2 = () -> System.out.println("aa");

        Runnable runnable3 = () -> {
            System.out.println("aa");
            System.out.println("aa");
        };


        ActionListener actionListener = e -> System.out.println(e.getActionCommand());

        BinaryOperator<Long> add = (x,y) -> x+y;

        BinaryOperator<Integer> addInt = (Integer x, Integer y) -> x + y;
    }
}


