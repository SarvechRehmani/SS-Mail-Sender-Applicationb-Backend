package com.email.services;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

@Service
public interface MailService {

    void sendMailWithHtml(String []to, String []cc, String subject, String htmlContent);
    void sendMailWithHtmlAndFile(String []to, String []cc, String subject, String htmlContent, InputStream stream, String fileName);
}
