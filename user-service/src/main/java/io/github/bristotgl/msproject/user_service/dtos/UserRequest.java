package io.github.bristotgl.msproject.user_service.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull
        @Size(min = 3, max = 80)
        String name,

        @NotNull
        @Size(min = 3, max = 40)
        String email
) {
}
