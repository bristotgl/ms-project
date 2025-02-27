package io.github.bristotgl.msproject.email_service.services;

import io.github.bristotgl.msproject.email_service.enums.EmailStatus;
import io.github.bristotgl.msproject.email_service.models.Email;
import io.github.bristotgl.msproject.email_service.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    private final EmailRepository emailRepository;

    public EmailService(JavaMailSender emailSender, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.emailRepository = emailRepository;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public void sendEmail(Email email) {
        try {
            email.setEmailSendDate(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            emailSender.send(message);
            email.setEmailStatus(EmailStatus.SENT);
        } catch (Exception e) {
            email.setEmailStatus(EmailStatus.ERROR);
        }

        emailRepository.save(email);
    }
}
