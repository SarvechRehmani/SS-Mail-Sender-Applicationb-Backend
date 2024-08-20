package com.email.controllers;

import com.email.helper.EmailRequest;
import com.email.helper.EmailResponse;
import com.email.services.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private MailService mailService;

    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendEmailWithHtml(@RequestBody EmailRequest request){
        mailService.sendMailWithHtml(request.getTo(), request.getCc(), request.getSubject(), request.getHtmlContent());
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email send successfully..").status(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public  ResponseEntity<EmailResponse> sendEmailWithHtmlAndFile(@RequestPart EmailRequest request, @RequestPart MultipartFile file) throws IOException {
        mailService.sendMailWithHtmlAndFile(request.getTo(), request.getCc(), request.getSubject(), request.getHtmlContent(), file.getResource().getFile());
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email send successfully..").status(HttpStatus.OK).success(true).build()
        );
    }
}
