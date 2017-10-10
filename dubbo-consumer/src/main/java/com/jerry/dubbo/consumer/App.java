package com.jerry.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jerry.dubbo.api.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        UserService userService = context.getBean(UserService.class);
        System.out.println("consumer");
        System.out.println(userService.sayHello("jerry"));
    }
}
