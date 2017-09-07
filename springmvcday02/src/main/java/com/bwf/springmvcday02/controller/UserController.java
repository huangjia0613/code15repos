package com.bwf.springmvcday02.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.springmvcday02.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	/**
	 * Controller对应的Bean组件受springmvc管理，不受spring容器管理
	 * 我们可以把spring管理的Bean组件注入给Springmvc，但是反过来不可以
	 */
	@Autowired
	private IUserService userService;

	@RequestMapping("/show")
	public String showAllUser(Map<String, Object> map){
		
		map.put("users", userService.findAllUser());
		
		return "userlist";
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
