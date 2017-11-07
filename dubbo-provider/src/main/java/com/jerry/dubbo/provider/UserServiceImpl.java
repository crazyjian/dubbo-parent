package com.jerry.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.jerry.dubbo.api.UserService;

/**
 * Hello world!
 *
 */
@Service
public class UserServiceImpl implements UserService {

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello " + name + ",welcome to dubbo !";
	}
	
}
