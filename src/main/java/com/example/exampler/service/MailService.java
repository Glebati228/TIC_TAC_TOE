package com.example.exampler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String emailto, String subject, String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        System.out.println("MailService" + username);
        mailMessage.setTo(emailto);
        System.out.println("MailService" + emailto);
        mailMessage.setSubject(subject);
        System.out.println("MailService" + subject);
        mailMessage.setText(message);
        System.out.println("MailService" + message);
        javaMailSender.send(mailMessage);
    }
}
