package io.github.bristotgl.msproject.user_service.dtos;

import java.util.UUID;

public record UserResponse(
        UUID userId,
        String name,
        String email
) {
}
