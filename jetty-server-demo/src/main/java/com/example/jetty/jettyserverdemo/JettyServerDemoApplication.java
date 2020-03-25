package com.example.jetty.jettyserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JettyServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JettyServerDemoApplication.class, args);
	}
	
//	@Bean
//	public ConfigurableServletWebServerFactory webServerFactory() 
//	{
//	    JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
//	    factory.setPort(9000);
//	    factory.setContextPath("/myapp");
//	    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
//	    return factory;
//	}


}
