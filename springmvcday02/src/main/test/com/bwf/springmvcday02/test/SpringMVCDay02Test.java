package com.bwf.springmvcday02.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bwf.springmvcday02.controller.UserController;
import com.bwf.springmvcday02.service.IUserService;
import com.bwf.springmvcday02.service.Impl.UserDaoImpl;
import com.bwf.springmvcday02.service.Impl.UserServiceImpl;

public class SpringMVCDay02Test {

	/**
	 * 测试Spring容器
	 * 在获取相应实现类的Bean组件时，有3中大的方式：
	 * a、通过名称获取：1、默认情况下是对应实现类的首字母小写，如：userServiceImpl是UserServiceImpl的Bean组件
	 *              2、在Service注解为@Service("userService")的情况下，userService是UserServiceImpl的Bean组件
	 * b、通过实体类获取，如：UserServiceImpl.class
	 * c、通过接口获取，如：UserService.class
	 * b和c的实际都是指的同一个类型，Autowired注解是按照类型注入的
	 * 1、测试UserServiceImpl
	 */
	@Test
	public void test01(){
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//从Spring容器中获取名称userServiceImpl的Bean组件(动态生成的对象，相当于UserService接口的实现类)
		UserServiceImpl userService = (UserServiceImpl) cpxac.getBean(UserServiceImpl.class);
		
		System.out.println(userService);
		System.out.println(userService.getUserMapper());
	}
	
	
	//2、测试UserDaoImpl组件
	@Test
	public void test02(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//从Spring容器中获取UserDaoImpl组件
		UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");
		
		System.out.println(userDao);
		System.out.println(userDao.getUser());
	}
	
	
	//3、测试UserController组件
	//因为Controller对应的Bean组件受springmvc管理，不受spring容器管理，所以会 测试失败。
	//我们可以把spring管理的Bean组件注入给Springmvc，但是反过来不可以把Controller注入给springMVC中的Bean组件
	@Test
	public void test03(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//从容器中获取UserController组件
		UserController userController = (UserController) context.getBean("userController");
		
		System.out.println(userController);
	
	}
}
