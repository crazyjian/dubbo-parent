package com.jerry.dubbo.consumer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.evcorp.service.demo.DemoService;
import com.jerry.dubbo.api.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
    	 //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        UserService userService = context.getBean(UserService.class);
        System.out.println("consumer");
        while(true){
        	Thread.sleep(2000);
        	String result = userService.sayHello("jim");
        	Future<String> f = RpcContext.getContext().getFuture();
        	System.out.println(f.get());
        }
    }
}
