package com.jerry.dubbo.provider;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jerry.dubbo.api.UserService;

@ImportResource("classpath:provider.xml")
@Controller
@SpringBootApplication
public class Provider {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/home")
    @ResponseBody
    String home() {
    	String str = userService.sayHello("jerry");
        return "提供方："+str;
    }

	public static void main(String[] args) throws IOException {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        System.out.println(context.getDisplayName() + ": here");
        context.start();
        System.out.println("服务已经启动...");
        System.in.read();*/
		SpringApplication.run(Provider.class,  "--server.port=8081");
    }
	
}
