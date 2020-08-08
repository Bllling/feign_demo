package com.lin.springcloud.feign.server.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="user-service")
public interface IRemoteUser {
	@GetMapping("/hello")
	public String getHello();
}
