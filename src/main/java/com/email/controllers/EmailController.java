package com.email.controllers;

import com.email.helper.*;
import com.email.services.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin("*")
public class EmailController {

    private final MailService mailService;

    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendEmailWithHtml(@RequestBody EmailRequest request){
        System.out.println(request+":"+request.getCc().length);
        mailService.sendMailWithHtml(request.getTo(), request.getCc(), request.getSubject(), request.getHtmlContent());
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email send successfully..").status(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-with-file")
    public  ResponseEntity<EmailResponse> sendEmailWithHtmlAndFile(@RequestParam("request") String request1, @RequestParam("file") MultipartFile file) throws IOException {
        InputStream stream = file.getInputStream();
        String fileName = file.getResource().getFilename();

        EmailRequest request = new ObjectMapper().readValue(request1, EmailRequest.class);


        mailService.sendMailWithHtmlAndFile(request.getTo(), request.getCc(), request.getSubject(), request.getHtmlContent(), stream, fileName);
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email send successfully..").status(HttpStatus.OK).success(true).build()
        );
    }


}
