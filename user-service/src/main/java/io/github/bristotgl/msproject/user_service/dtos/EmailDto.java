package io.github.bristotgl.msproject.user_service.dtos;

import java.util.UUID;

public record EmailDto(
        UUID userId,
        String emailTo,
        String subject,
        String text
) {
}
