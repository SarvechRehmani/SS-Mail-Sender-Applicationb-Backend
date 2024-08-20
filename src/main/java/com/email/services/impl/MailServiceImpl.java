package com.email.services.impl;


import com.email.services.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;

    @Value("${project.from}")
    private String from;

    private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String to, String []cc, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setCc(cc);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(from);
        javaMailSender.send(mailMessage);
        logger.info("Mail sent to {} with subject: {}", to, subject);
    }

    @Override
    public void sendMail(String[] to, String []cc, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setCc(cc);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(from);
        javaMailSender.send(mailMessage);
        logger.info("Mail sent to {} with subject: {}", to, subject);
    }

    @Override
    public void sendMailWithHtml(String to, String []cc, String subject, String htmlContent) {
        MimeMessage simpleMailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setFrom(from);
            helper.setText(htmlContent, true);
            javaMailSender.send(simpleMailMessage);
            logger.info("Mail sent to {} with subject: {}", to, subject);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMailWithHtml(String[] to, String []cc, String subject, String htmlContent) {
        MimeMessage simpleMailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setFrom(from);
            helper.setText(htmlContent, true);
            javaMailSender.send(simpleMailMessage);
            logger.info("Mail sent to {} with subject: {}", to, subject);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMailWithHtmlAndFile(String[] to, String []cc, String subject, String htmlContent,  File file) {
        MimeMessage simpleMailMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");;
            helper.setFrom(from);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            FileSystemResource resource = new FileSystemResource(file);
            helper.addAttachment(Objects.requireNonNull(resource.getFilename()),file);
            javaMailSender.send(simpleMailMessage);
            logger.info("Mail sent to {} with subject: {}", to, subject);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
