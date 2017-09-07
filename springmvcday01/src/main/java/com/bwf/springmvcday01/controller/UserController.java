package com.bwf.springmvcday01.controller;

import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bwf.springmvcday01.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	//可通过：http://localhost:8080/springmvvcday01/user/home
	//1、不传参数
	@RequestMapping("/home")
	public String home(){
		
		System.out.println("--------------------");
		
		return "home";
	}
	
	//2、传递参数(无需返回值)
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password){
		
		System.out.println(username + "\t" + password);
		
		return "login";
	}
	
	
	//3、有返回值
	@RequestMapping("/show-user")
	public ModelAndView showUser(){
		ModelAndView mv = new ModelAndView();
		
		//指定视图名称
		mv.setViewName("userlist");
		
		//使用ModelAndView存放数据，这里存放了一个User
		//实际上User对象是放到了request请求域当中的
		//我们可以使用${requestScope.user.name}获取user对象的属性值
		mv.addObject("user", new User("kaikai", new Date(), "man"));
		
		return mv;
	}
	
	
	//使用Model封装数据
	@RequestMapping("/testmodel")
	public String testModel(Model model){
		//request  user ${requestScope.user.name}
		model.addAttribute("user", new User("yuefei", new Date(), "man"));

		return "userlist";
	}
	
	
	//使用Map封装数据
	@RequestMapping("testMap")
	public String testMap(Map<String, Object> map){
		//向Map中添加对象
		map.put("user", new User("huangdi", new Date(), "woman"));
		
		return "userlist";
	}
	
	/***Ant风格  URL
	 *   ？  任意一个字符
	 *   * 任意多个字符
	 *   ** 多层路径
	 * @return
	 */
	//任意一个字符 ？
	@RequestMapping("/ant01/?")
	public String testAnt01(){
		return "home";
	}
	
	//任意多个字符 *
	@RequestMapping("/ant02/*")
	public String testAnt02(){
		return "home";
	}
	
	//多层路径  **
	@RequestMapping("/ant03/**")
	public String testAnt03(){
		return "home";
	}
	
	
	//PathVariable注解使用
	@RequestMapping("/path/{zoo}/{animal}")
	public String testPathVariable(@PathVariable("zoo") String zoo,@PathVariable("animal") String animal){
		System.out.println(zoo+"\t"+animal);
		return "home";
	}
	
	
	/**ajax
	 *   text
	 *   json
	 *   xml
	 * @return
	 */
	@RequestMapping("/ajax/text")
	@ResponseBody
	//异步请求返回普通文本  即：text文本
	public String testAjaxResponseText(){
		return "hello,boss!!";
	}
	
	
	//异步请求返回json  问题：在开始我返回String的时候，连接失败，返回类型改为User之后成功。是因为json返回的是对象数组，格式为：{"":"","":"",...}
	@RequestMapping("/ajax/json")
	@ResponseBody
	public User testAjaxResponseJson(){
		
		return new User("zhangwuji", new Date(), "man");
	}
	
	
	//异步请求返回json数组    注意这种格式，里面有value和produces，前者描述输入路径，后者描述环境和编译语言
	@RequestMapping(value="/ajax/jsonarray",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public List<User> testAjaxPesponseJsonArray(){
		List<User> list = new ArrayList<>();
		User user = new User("zhaomin", new Date(), "woman");
		list.add(user);
		return list;
	}
	
	
	//异步请求用Xml解析
	/**在导入了jackson-dataformat-xml组件的情况下，SpringMVC会优先返回xml格式的数据
	 * 如果想要返回json格式的数据，那么就要显示指定products的值为：application/json，charset=UTF-8;
	 * 这样设置以后SpringMVC就知道返回json格式的数据
	 * @return
	 * @GetMapping(value="/ajax/xml",produces={"application/json";"charset=UTF-8"})
	 * @GetMapping(value="/ajax/json",produces={"application/json";"charset=UTF-8"})
	 */
	@RequestMapping("/ajax/xml")
	@ResponseBody
	public List<User> testAjaxResponseXml(){
		List<User> list = new ArrayList<>();
		User user = new User("huojing", new Date(), "man");
		list.add(user);
		return list;
	}
	
	
	/**POST请求
	 * 使用params可以实现更细粒度的限制：
	 * ！school 表示请求中不能包含school参数  才能访问该接口
	 * name=abc 表示请求参数中必须包含那么参数  且值为：abc
	 * age 请求参数中必须包含age参数
	 * sex!=man 表示参数中包含sex参数  但是值不能为man
	 * @return
	 */
	@RequestMapping(value="/post",
			method=RequestMethod.POST,params={"!school","name=abc","age","sex!=man"})
	public String testPostRequset(){
		return "home";
	}
	
	
	@RequestMapping(value="/testheader",
			method=RequestMethod.GET,headers={"!name","taken=123"})
	public String testHeaderRequset(){
		return "home";
	}

	
	//@PostMapping注解作用等同于：@RequestMapping(value="/postrequest",method=RequestMethod.POST)
	@PostMapping("/postrequest")
	public String testPostRequest02(){
		
		return "home";
	}
	
	
	//method=RequestMethod.GET注解作用等同于：@RequestMapping(value="/testget",method=RequestMethod.GET)
	@GetMapping("/testget")
	public String testGetRequest(){
		
		return "home";
	}
	
	/**
	 * Servlet注解，除特殊情况一般不用(因为本来springMVC的作用就是替换掉servlet的功能的)
	 * @param request
	 * @return
	 */
	@RequestMapping("/request")
    public String testRequest(HttpServletRequest request){
    	request.setAttribute("", "");
    	request.getCookies();
    	System.out.println(request.getParameter("param"));
    	
    	request.getSession();
    	request.getContextPath();
    	return "home";
    }
	
	
	@RequestMapping("/cookie")
	public String testRequest(@CookieValue("account") String value){
		System.out.println("***:"+value);
		return "home";
	}
	
	
	@RequestMapping("/response")
	public String testReponse(HttpServletResponse response){
		
		Cookie cookie = new Cookie("account", "51Code");
		response.addCookie(cookie);
		//redirect表示重定向
		return "redirect:/user/cookie";
	}
	
	
	/**
	 * 当使用PrintWriter输出内容的时候，就无需再有返回值
	 * @param out
	 */
	@RequestMapping("/writer")
	public void testPrintWriter(PrintWriter out){
		out.write("<h2>haha.......hehe</h2>");
	}
	
}
