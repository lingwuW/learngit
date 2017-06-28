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
 * Dispatcher Servletǰ�˿��ƿ��أ�������Handler������������������ViewResolver��������Viewӳ�䣩
 * �����һ��������Handler����tomcat��filter���������ƣ�
 * ������ķ������Ǿ���Ĵ����߼���ҵ���߼�������ɣ�����ModelAndView
 * Dispatcher���õ���View����ViewResolver����ҳ����Ⱦ��������ɣ����أ�response�������
 * һ��request--response����
 * 
 * 
 * �������Щע�����õľ���HandlerMapping��HandlerAdapterӳ���ϵ
 * */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	/**
	 * �ڿ������и���������
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
	 * ��ǰ�˷���һ��User����
	 * ModelAndView�е�Model����Ĭ�϶��Ƿ���request�������е�
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
	 * �����첽����   ����xml
	 * */
	/**
	 * �ڵ�����jackson-dataformat-xml���������£�SpringMVC�����Ȳ���XML��ʽ��������;
	 * ���Ҫ����json��ʽ���أ�����Ҫ��ʾָ��produces��ֵΪapplication/json;charset=UTF-8,�������ù���SpringMVC��֪������JSON��ʽ�����ݡ�
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
	 * ʹ��Model����Map�����Ӧ���ݡ�
	 * Model��Map������ͼһ�𱻷�װΪModelAndView��
	 * ��Ӧ���ݹ������Ǵ����request�������С�
	 * ��ҿ���˼��һ��ΪʲôҪ������������У������ǻỰ����?
	 * �����򾿾����Դ�Ŷ�������?
	 * �������Ⱦ��ͼ  ����HTML ��Ӧ���ͻ���  request�Ƿ���˶���  ���ڷ�����ڴ���  ��������д�ŵ�����������ȡ���ڷ�����ڴ�ռ䡣
	 * ��Ȼ��Ϊ�������Ӧ�ٶȣ�һ��һ��HTML��������ع�������ݡ�
	 * ֱ��requestScope.school�Ϳ��Եõ�����ֵ��
	 * */
	@RequestMapping("/testmap")
	public String testMap(Map<String, Object> map){
		
		//������JSP��ͼ��ʹ��EL���ʽ��requestScope�����������ݡ�
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
