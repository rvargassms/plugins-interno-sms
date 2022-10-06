package com.biblos.util;

import java.io.File;
import java.io.IOException;

import com.dotmarketing.util.Mailer;

public class EmailUtil {
	
	public static final String EMAIL_SYSTEM_ADDRESS = "EMAIL_SYSTEM_ADDRESS";
	public static final String EMAIL_EQUIPO_CONTENIDO = "EMAIL_EQUIPO_CONTENIDO";
	public static final String EMAIL_DEFAULT_ADDRESS = "website@dotcms.com";
	
	public static boolean sendEmail(String emailAddress, String subject, String htmlBody, String fromEmail, File file)
			throws IOException {
		Mailer m = new Mailer();
		m.setToEmail(emailAddress);
		m.setSubject(subject);
		m.setHTMLBody(htmlBody);
		m.setFromEmail(fromEmail);
		if (file != null) {
			m.addAttachment(file, file.getName());
			boolean ok = m.sendMessage();
			return ok;
		}

		return m.sendMessage();
	}

}
