package com.bwf.springmvcday02.mapper;

import java.util.List;

import com.bwf.springmvcday02.pojo.User;

public interface UserMapper {
	
	public List<User> findAllUser();
	
}