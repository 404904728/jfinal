package demo;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;

/**
 * 
 * Title: HelloController.java

 * Package demo 
 * 
 * Description:TODO
 * 
 * Copyright: Copyright (c) 2014
 * 
 * Company: 蓝图信息产业股份有限公司
 * 
 * @author ztb

 * @date 2014上午9:18:23

 * @version V1.0
 */
@Before(DemoInterceptor.class)  
public class HelloController extends Controller{
	
	
	public void index() {
		renderText("Hello JFinal World. Test haha");
	}
	
	public void page() {
		System.out.println(getPara(0)+"================================"+getPara(2));
		renderText("come here ...");
	}
	
	public void user() {
		renderText("Hello JFinal");
		setAttr("per", "Test set Attr ...");
		
		List<User> list = new User().find("select * from user_t");
		renderJson(list);
		//renderJsp("test.jsp");
	}
}
