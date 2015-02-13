package com.infrastructure.util;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.infrastructure.extension.StringHelper;
import com.management.model.Account;
import com.management.service.AccountService;

public class MailUtil {

	@Autowired
	@Qualifier("AccountService")
	private AccountService accountService;

	private static final String EMAIL_FROM = "306495794@qq.com";
	private static final String PASSWORD = "lz123456";

	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	/**
	 * 发送重设密码链接的邮件
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public static int sendResetPasswordMail(Account account) throws NoSuchAlgorithmException {

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		String secretKey = UUID.randomUUID().toString(); // 密钥
		Timestamp outDate = new Timestamp(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
		long date = outDate.getTime() / 1000 * 1000;// 忽略毫秒数 mySql 取出时间是忽略毫秒数的
		String key = account.getUsername() + "$" + date + "$" + secretKey;
		String digitalSignature = StringHelper.md5(key);// 数字签名

		String resetPassHref = "http://localhost:8080/management/account/resetPassword" + "?sid=" + digitalSignature + "&userName=" + account.getUsername();
		String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href=" + resetPassHref + " target='_BLANK'>" + resetPassHref + "</a>  或者    <a href="
				+ resetPassHref + " target='_BLANK'>点击我重新设置密码</a>" + "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'" + key + "\t" + digitalSignature;

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_FROM, PASSWORD);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");

			message.setFrom(new InternetAddress(EMAIL_FROM));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(account.getEmail()));
			message.setSubject("aa");
			message.setText(emailContent);
			Transport.send(message);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static void main(String[] args) {
		Account account = new Account();
		account.setId(14);
		account.setUsername("harry");
		account.setEmail("916858799@qq.com");
		try {
			sendResetPasswordMail(account);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
