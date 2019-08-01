package com.example.exampler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig
{
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String prot;

    @Value("${spring.mail.username}")
    private String name;

    @Value("${spring.mail.password}")
    private String pass;

    @Value("${mail.debug}")
    private String debug;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String enable;

    @Bean
    public JavaMailSender mailSender()
    {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setUsername(name);
        System.out.println("MailConfig " + name);
        javaMailSender.setPassword(pass);
        System.out.println("MailConfig " + pass);
        javaMailSender.setPort(port);
        System.out.println("MailConfig " + port);
        javaMailSender.setHost(host);
        System.out.println("MailConfig " + host);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.transport.protocol", prot);
        System.out.println("MailConfig " + prot);
        properties.put("mail.debug", debug);
        System.out.println("MailConfig " + debug);
        properties.setProperty("mail.smtp.auth", auth);
        properties.setProperty("mail.smtp.starttls.enable", enable);

        return javaMailSender;
    }
}
