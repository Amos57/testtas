package com.testtask.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
	
		AnnotationConfigWebApplicationContext acwac=new AnnotationConfigWebApplicationContext();
		acwac.register(SpringConfig.class,WebConfig.class);
		acwac.setServletContext(arg0);
	ServletRegistration.Dynamic dis=	arg0.addServlet("dispatcher",new DispatcherServlet(acwac));
		dis.setLoadOnStartup(1);
		dis.addMapping("/");
		
	}

}
