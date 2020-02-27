package com.docsconsole.tutorials.springmvc5.config;

import java.io.File;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.XmlViewResolver;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.docsconsole.tutorials.springmvc5.*"})
public class WebMvcConfig  {
	
	@Autowired
	ServletContext servletContext;
	
   @Bean
   public XmlViewResolver xmlViewResolver() {
	   XmlViewResolver xmlViewResolver = new XmlViewResolver();
	   Resource resource = new FileSystemResource(new File( servletContext.getRealPath("/WEB-INF/spring-views.xml") ));
	   xmlViewResolver.setLocation(resource);
	   return xmlViewResolver;
   }
 
   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
}