package org.geeksexception.web.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.geeksexception.web.model.Concern;

public class MailService {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private Properties properties;
	
	private String username;
	
	private String password;
	
	public void sendConcern(Concern concern) {
		
		Session session = Session.getDefaultInstance(getProperties(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								username, 
								password);
					}
				});
		
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(concern.getEmail()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("support@geeksexception.com"));
			message.setSubject("GeeksException: Concern");
			message.setText(String.format("Name: %s\nPhone Number: %s\nEmail: %s\nConcern: %s", 
					concern.getName(), 
					concern.getPhone(), 
					concern.getEmail(), 
					concern.getConcern()));
 
			Transport.send(message);
 
			logger.info(String.format("Sending mail: %s", message.toString()));
 
		} catch (MessagingException e) { logger.error(e.getMessage()); }
		
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}