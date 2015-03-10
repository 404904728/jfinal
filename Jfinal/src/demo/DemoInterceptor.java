package demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 
 * Title: DemoInterceptor.java

 * Package demo 
 * 
 * Description:TODO
 * 
 * Copyright: Copyright (c) 2014
 * 
 * Company: 蓝图信息产业股份有限公司
 * 
 * @author ztb

 * @date 2014下午12:04:23

 * @version V1.0
 */
public class DemoInterceptor implements Interceptor{

	/* (non-Javadoc)
	 * @see com.jfinal.aop.Interceptor#intercept(com.jfinal.core.ActionInvocation)
	 */
	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before controller invoking.......");
		ai.invoke();
		System.out.println("After controller invoking.........");
		
	}
}
