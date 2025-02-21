package io.github.bristotgl.msproject.user_service.controllers;

import io.github.bristotgl.msproject.user_service.dtos.UserRequest;
import io.github.bristotgl.msproject.user_service.dtos.UserResponse;
import io.github.bristotgl.msproject.user_service.models.User;
import io.github.bristotgl.msproject.user_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = userService.createUser(userRequest);
        UserResponse userResponse = new UserResponse(user.getUserId(), user.getName(), user.getEmail());

        URI location = uriBuilder.path("/users/{id}").buildAndExpand(userResponse.userId()).toUri();

        return ResponseEntity.created(location).body(userResponse);
    }
}
