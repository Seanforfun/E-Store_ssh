package ca.mcmaster.shop.utils;

import java.util.Properties;
import java.util.ResourceBundle;

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

import ca.mcmaster.shop.user.User;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 10:18:30 PM
 */
public class MailUtils {
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		Properties props = new Properties();
		SenderEmailBuilder builder = new SenderEmailBuilder("mail");
		SenderEmail info = builder.newInstance();
		props.setProperty("mail.transport.protocol", info.getProtocol());
		props.setProperty("mail.host", info.getHost());
		props.setProperty("mail.smtp.port", info.getPort());
		
		props.setProperty("mail.smtp.auth", info.getAuth());
		props.setProperty("mail.smtp.starttls.enable", info.getEnableTLS());
		final String emailFrom = info.getEmail();
		final String password = info.getPassword();
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailFrom, password);
			}
		};

		Session session = Session.getInstance(props, auth);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(info.getEmail()));
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		message.setSubject("Account active!");
		message.setContent(emailMsg, "text/html;charset=utf-8");
		Transport.send(message);
	}

	public static void sendActiveEmail(User u) throws AddressException,
			MessagingException {
		String emailMsg = "Register success! Please <a href=http://localhost:80/E-store/user_active?user_activative_code="
				+ u.getUser_activative_code()
				+ ">active</a> your account, active code is "
				+ u.getUser_activative_code() ;
		MailUtils.sendMail(u.getUser_email(), emailMsg);
	}
}

class SenderEmail {
	private String email;
	private String password;
	private String host;
	private String port;
	private String enableTLS;
	private String auth;
	private String protocol;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setEnableTLS(String enableTLS) {
		this.enableTLS = enableTLS;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getEnableTLS() {
		return enableTLS;
	}

	public String getAuth() {
		return auth;
	}

	public String getProtocol() {
		return protocol;
	}
}

class SenderEmailBuilder extends SenderEmail {
	private static SenderEmail senderEmail = new SenderEmail();
	private ResourceBundle bundle = null;

	public SenderEmailBuilder(String emailResource) {
		this.bundle = ResourceBundle.getBundle(emailResource);
	}

	public SenderEmail newInstance() {
		senderEmail.setEmail(bundle.getString("email"));
		senderEmail.setPassword(bundle.getString("password"));
		senderEmail.setEnableTLS(bundle.getString("enableTLS"));
		senderEmail.setHost(bundle.getString("host"));
		senderEmail.setPort(bundle.getString("port"));
		senderEmail.setAuth(bundle.getString("auth"));
		senderEmail.setProtocol(bundle.getString("protocol"));
		return senderEmail;
	}
}