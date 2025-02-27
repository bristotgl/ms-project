package io.github.bristotgl.msproject.email_service.repositories;

import io.github.bristotgl.msproject.email_service.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
