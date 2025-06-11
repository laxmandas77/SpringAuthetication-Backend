package com.das.springAuth.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.properties.mail.smtp.from}")
    private String fromMail;

    public void sendWelcomeEmail(String toEmail,String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(toEmail);
        message.setSubject("Welcome to Our Platform");
        message.setText("Hello"+name+",\n\nThanks for registering with us!\n\nRegards,\n Authify Team");
        mailSender.send(message);
    }

    public void sendResetOtpEmail(String toEmail,String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(toEmail);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for resetting your password is "+otp+".Use this OTpp to proceed with resetting your password");
        mailSender.send(message);

    }

    public void senOtpEmail(String toEmail,String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(toEmail);
        message.setSubject("Account Verification OTP");
        message.setText("Your OTP is "+otp+". Verify your account using this OTP.");
        mailSender.send(message);
    }
}
