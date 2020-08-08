package com.lin.springclound.eureka.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	// 高版本的spring cloud会默认启动csrf功能，即跨域访问,
	// 因为注册服务，所以不需要跨域访问，所以该函数的功能为放过跨域访问
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/eureka/**");
	}
}
