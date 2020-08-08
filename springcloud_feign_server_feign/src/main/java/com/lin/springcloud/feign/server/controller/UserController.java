package com.lin.springcloud.feign.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.springcloud.feign.server.remote.IRemoteUser;

@RestController
public class UserController {
	@Autowired
	private IRemoteUser remoteUser;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 面向服务器调用
	 * @return
	 */
	@GetMapping("/hi")
	public String helloConsumer() {
		System.out.println("当前Eureka中注册服务器有：");
		List<String> list = discoveryClient.getServices();
		
		//lamba
		list.forEach(System.out::println);
		// list.forEach(x -> System.out.println(x));
		
		return remoteUser.getHello();

	}
	
	@RequestMapping("/test")
	public String test(){
		return "test end";
	}
}
