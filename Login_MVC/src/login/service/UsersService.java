package login.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import login.db.Users;

public class UsersService 
{
	public static void sendPassword(Users u) 
	{
	    String to = u.getEmail();
	    String subject = "Password Sent";
	    String message = "Hello Dear , Your Password is : " + u.getPassword();

	    String from = "debi1234mishra@gmail.com";
	    final String password = "password1234567890pm";
	    try
	    {
	      Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.port", "465");

	      Authenticator auth = new Authenticator() 
	      {
	        public PasswordAuthentication getPasswordAuthentication() 
	        {
	          return new PasswordAuthentication(from, password);
	        }
	      };
	      Session session = Session.getInstance(props, auth);

	      MimeMessage msg = new MimeMessage(session);
	      msg.setFrom(new InternetAddress(from));
	      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	      msg.setSubject(subject);
	      msg.setText(message);

	      Transport.send(msg);
	      System.out.println("Message delivered successfully , Check your mail ...........");
	    }
	    catch (MessagingException e)
	    {
	      e.printStackTrace();
	    }
	}
}
