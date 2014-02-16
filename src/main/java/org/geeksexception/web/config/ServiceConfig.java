package org.geeksexception.web.config;

import java.util.Properties;

import javax.inject.Inject;

import org.geeksexception.web.service.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:mail.properties")
public class ServiceConfig {
	
	@Inject private Environment env;
	
	@Bean
	public MailService mailService() {
		
		MailService mailService = new MailService();
		Properties properties = new Properties();
		properties.put("mail.smtp.host", env.getProperty("google.mail.smtp.host"));
		properties.put("mail.smtp.socketFactory.port", env.getProperty("google.mail.smtp.socketFactory.port"));
		properties.put("mail.smtp.socketFactory.class", env.getProperty("google.mail.smtp.socketFactory.class"));
		properties.put("mail.smtp.auth", env.getProperty("google.mail.smtp.auth"));
		properties.put("mail.smtp.port", env.getProperty("google.mail.smtp.port"));
		
		mailService.setProperties(properties);
		mailService.setUsername(env.getProperty("google.mail.username"));
		mailService.setPassword(env.getProperty("google.mail.password"));
		
		return mailService;
		
	}
}