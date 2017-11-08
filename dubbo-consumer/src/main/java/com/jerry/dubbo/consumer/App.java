package com.jerry.dubbo.consumer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.evcorp.service.demo.DemoService;
import com.jerry.dubbo.api.UserService;

/**
 * Hello world!
 *
 */
@ImportResource("classpath:consumer.xml")
@Controller
@SpringBootApplication
public class App 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/say")  
	@ResponseBody
    public String sayHello() throws InterruptedException, ExecutionException {  
		String str = userService.sayHello("jim");
		Future<String> f = RpcContext.getContext().getFuture();
        return "消费方：" + f.get();  
    }  
	
    public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
    	 //测试常规服务
      /*  ClassPathXmlApplicationContext context =
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
        }*/
    	SpringApplication.run(App.class, "--server.port=8080");
    }
}
