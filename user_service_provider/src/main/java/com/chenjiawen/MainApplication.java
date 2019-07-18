package com.chenjiawen;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: jiawen.chen
 * @Date: 2019/7/17 21:58
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath*:provider.xml");
        context.start();
        System.in.read();
    }
}
