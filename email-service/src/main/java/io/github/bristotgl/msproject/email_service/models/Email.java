package io.github.bristotgl.msproject.email_service.models;

import io.github.bristotgl.msproject.email_service.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@Data
public class Email implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "email_id")
    private UUID emailId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "email_from", length = 40, nullable = false)
    private String emailFrom;

    @Column(name = "email_to", length = 40, nullable = false)
    private String emailTo;

    @Column(name = "subject", length = 150, nullable = false)
    private String subject;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "email_send_date", nullable = false)
    private LocalDateTime emailSendDate;

    @Column(name = "email_status", nullable = false)
    private EmailStatus emailStatus;
}
