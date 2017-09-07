package com.bwf.springmvcday02.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.springmvcday02.mapper.UserMapper;
import com.bwf.springmvcday02.pojo.User;
import com.bwf.springmvcday02.service.IUserService;

/**
 * Service注解用于标识当前组件是一个Service组件
 * 这样在测试的时候，我们获取相应的Bean组件就能够获取得到(最常用)
 * 如果当前组件并没有用Service标识，那么就需要在xml里面；配置相关的参数id和name(一般不用)
 * */
@Service()
public class UserServiceImpl implements IUserService{

	/**
	 * Autowired的作用是告诉Spring在Spring容器中找到类型为UserMapper的实例对象注入给当前实例变量
	 * */
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllUser() {
		
		
		return userMapper.findAllUser();
	}

	
	
	//必须要有这个，不然没有办法在datasource不能找到相应的对象UserMapper
	//特别是set方法
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
}
