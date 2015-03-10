package demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * 
 * Title: DemoConfig.java

 * Package demo 
 * 
 * Description:TODO
 * 
 * Copyright: Copyright (c) 2014
 * 
 * Company: 蓝图信息产业股份有限公司
 * 
 * @author ztb

 * @date 2014上午9:17:27

 * @version V1.0
 */

public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class,"/app/user");
	}

	public void configPlugin(Plugins me) {
		loadPropertyFile("your_app_config.txt");
		C3p0Plugin c3p0Plugin =  new  C3p0Plugin(getProperty("url"), 
		getProperty("username"), getProperty("password"),getProperty("driverClassName"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.setContainerFactory(new  CaseInsensitiveContainerFactory());
		arp.setDialect(new OracleDialect());
		arp.addMapping("USER_T","ID_F", User.class);
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
	
	public static void main(String[] args) {
		JFinal.start("web", 8080, "/", 5);
	}
}
