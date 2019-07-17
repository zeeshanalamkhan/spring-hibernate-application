package com.zeeshan.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static final Logger logger = Logger.getLogger(MyWebAppInitializer.class);
	
	@Override
	protected Class<?>[] getRootConfigClasses() {

		logger.info("getRootConfigClasses method");
		return new Class[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		logger.info("getServletConfigClasses method");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		logger.info("getServletMappings method");
		return new String[] { "/" };
	}

}
