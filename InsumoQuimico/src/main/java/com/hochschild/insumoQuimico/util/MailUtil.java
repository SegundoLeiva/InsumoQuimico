package com.hochschild.insumoQuimico.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailUtil {

	static final Logger logger=LoggerFactory.getLogger(MailUtil.class);


	public static String enviarEmail(String host,String alias_from,String to,String cc,String asunto,String texto) {

		String mensaje = "";
		try{
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			
			Authenticator authenticator = null;
			
			
			Session session = Session.getDefaultInstance(props, authenticator);
			MimeMessage message = new MimeMessage(session);
			
			String remitente = "";

			remitente = alias_from;
			
			message.setFrom(new InternetAddress(remitente));
			
			message.addRecipients(Message.RecipientType.CC,  InternetAddress.parse(cc));
			message.addRecipients(Message.RecipientType.TO,  InternetAddress.parse(to));
			
			message.setSubject(asunto,"UTF-8");
			message.setText(texto, "ISO-8859-1","html");
			Transport.send(message);
			
			logger.info("MSJ ENVIADO A :"+to);
			
			mensaje = "OK";
		}catch(Exception e){
			
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			String strErrores = errors.toString();

			logger.error(strErrores);
			logger.error("ERROR AL ENVIAR CORREO : "+e.getLocalizedMessage());
			mensaje = "ERROR AL ENVIAR CORREO : "+e.getLocalizedMessage();
		}
		
		return mensaje;
	}
}

