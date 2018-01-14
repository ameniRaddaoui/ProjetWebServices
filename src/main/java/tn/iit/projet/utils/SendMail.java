package tn.iit.projet.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

	String mailTo;
	String mailText;

	public SendMail(String mailTo, String mailText) {

		String mailSmtpHost = "smtp.gmail.com";

		this.mailTo = mailTo;

		String mailFrom = "raddaouiameni@gmail.com";
		String mailSubject = "Gestion Des Salles";
		this.mailText = mailText;
		String PA = "RaddaouiAmeni";
		sendEmail(mailTo, mailFrom, mailSubject, mailText, mailSmtpHost, PA);
	}

	public static void sendEmail(String to, final String from, String subject, String text, String smtpHost,
			final String password) {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", smtpHost);
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.socketFactory.fallback", "false");
			
			Session session = Session.getInstance (properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});

			Message emailMessage = new MimeMessage(session);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			session.setDebug(true);

			Transport.send(emailMessage);
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
