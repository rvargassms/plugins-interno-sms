package com.biblos.loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class ProccessSpringContextLoader {
	private static ApplicationContext context;
	
	public static void init(){
		if (context==null) {
			context = new FileSystemXmlApplicationContext("classpath:spring/dotcms-security-plugin-root-spring.xml");
		}
	}
	
	public static Object getBean(String bean) {
		init();
		return context.getBean(bean);
	}
}
