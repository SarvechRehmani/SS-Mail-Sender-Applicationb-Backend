package com.email;

import com.email.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class SsMailApplication implements CommandLineRunner {

	@Autowired
	private MailService mailService;

	private final Logger logger = LoggerFactory.getLogger(SsMailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SsMailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Project started...");
//		String[] to = {"bhurgrishahjahan28@gmail.com"};
//		String[] cc = {"amanullah.bhurgri32@gmail.com", "sarwechkhatti@gmail.com"};
//		String html = "" +
//				"<h1 style='border:red 1px solid; color:red'>This Message come from spring boot project</h1>"
//				+ "";
//		File file = new File("D:\\Programs\\Email Sender Application\\SSMail\\src\\main\\resources\\static\\profile-pic.png");
//		try {
//			mailService.sendMailWithHtmlAndFile(
//					to,
//					cc,
//					"2nd mailHello This is Test Case of Mail Sending Application",
//					html,
//					file
//			);
//			logger.info("Message sent successfully.");
//		} catch (Exception e) {
//			logger.error("Error sending message", e);
//		}
	}
}
