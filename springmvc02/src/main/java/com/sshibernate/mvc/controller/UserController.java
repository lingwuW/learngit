package com.sshibernate.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sshibernate.mvc.domain.User;
import com.sshibernate.mvc.service.IUserService;

/**
 * springMVC
 * Dispatcher Servlet前端控制开关，它持有Handler处理器链；它还持有ViewResolver（它持有View映射）
 * 这就是一个处理器Handler（与tomcat中filter处理链相似）
 * 它里面的方法就是具体的处理逻辑，业务逻辑处理完成，返回ModelAndView
 * Dispatcher将得到的View交给ViewResolver处理页面渲染，处理完成，返回，response给浏览器
 * 一次request--response结束
 * 
 * 
 * 这里的这些注解配置的就是HandlerMapping、HandlerAdapter映射关系
 * */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	/**
	 * 在控制器中给出处理器
	 * */
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="username",required=true) String username,@RequestParam(value="pass",required=true) String pass){
		System.out.println(username+"  "+pass);
		return "home";
	}
	
	/*@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(@RequestParam(value="username",required=true) String username,@RequestParam(value="pass",required=true) String pass){
		System.out.println(username+"\t"+pass);
		return "index";
	}*/
	
	@RequestMapping(value="/xyz",method=RequestMethod.GET)
	public String noParam(){
		return "index";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String pojoRegist(User user){
		System.out.println(user.getName());
		return "index";
	}
	
	//@RequestMapping(value="/?")
//	@RequestMapping(value="/*b")
	/*@RequestMapping(value="/*")
	public String testAnt(){
		
		return "index";
	}*/
	
	/**
	 * 向前端返回一个User对象
	 * ModelAndView中的Model数据默认都是放在request对象域中的
	 * */
	@RequestMapping(value="/getuser")
	public ModelAndView findUser(@RequestParam(value="id",required=true) int id){
		User user=userService.findUserById(id);
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("usermap", user);
		Map<String, Object> model = mv.getModel();
		System.out.println(model.get("usermap"));
		return mv;
	}
	
	/**
	 * 处理异步请求   返回xml
	 * */
	/**
	 * 在导入了jackson-dataformat-xml组件的情况下，SpringMVC会优先采用XML格式返回数据;
	 * 如果要想以json格式返回，就需要显示指定produces的值为application/json;charset=UTF-8,这样设置过后SpringMVC就知道返回JSON格式给数据。
	 * */
	//@GetMapping(value="/finduser",produces={"application/xml;charset=UTF-8"})*/
	/*@GetMapping(value="/finduser",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public User findUser(@RequestParam(value="id",required=true) int id){
		
		User user=userService.findUserById(id);
		
		return user;
	}*/
	@RequestMapping(value="/testpath/{name}/{id}")
	public String testPathVariable(@PathVariable(value="name") String name,@PathVariable(value="id") int id){
		System.out.println(name+" "+id);
		return "home";
	}
	
	/**
	 * 使用Model或者Map存放响应数据。
	 * Model或Map将和视图一起被封装为ModelAndView。
	 * 响应数据归根结底是存放在request请求域中。
	 * 大家可以思考一下为什么要存放在请求域中，而不是会话域中?
	 * 请求域究竟可以存放多少数据?
	 * 服务端渲染视图  生成HTML 响应给客户端  request是服务端对象  存在服务端内存中  请求对象中存放的数据理论上取决于服务端内存空间。
	 * 当然，为了提高响应速度，一般一个HTML不建议承载过多的数据。
	 * 直接requestScope.school就可以得到它的值了
	 * */
	@RequestMapping("/testmap")
	public String testMap(Map<String, Object> map){
		
		//可以在JSP视图中使用EL表达式在requestScope遍历出该数据。
		map.put("school", "51code");
		return "home";
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
