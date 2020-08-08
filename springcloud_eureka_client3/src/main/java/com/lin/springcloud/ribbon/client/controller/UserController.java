package com.lin.springcloud.ribbon.client.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/hello")
	public String hello(){
		return "hello user: " + port;
	}
	
	@RequestMapping("/index")
	public void index(HttpServletResponse response) throws IOException{
		response.sendRedirect("/index.html");
	}
}
