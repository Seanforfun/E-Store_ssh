package ca.mcmaster.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 10:18:30 PM
 */
public class MailUtils {
	public static void sendEmail(String to, String code) throws AddressException, MessagingException{
		Properties properties = new Properties();
		properties.setProperty("mail.smtp", "localhost");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@seanforfun.ca", "111");
			}
};
		Session session = Session.getInstance(properties, auth);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@seanforfun.ca"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject("Account active!");
		String emailMsg = "Register success! Please <a href=http://localhost:80/E-store/user_active?user_activative_code="
				+ code
				+ ">active</a> your account, active code is "
				+ code;
		message.setContent(emailMsg, "text/html;charset=utf-8");
		Transport.send(message);
	}
}
