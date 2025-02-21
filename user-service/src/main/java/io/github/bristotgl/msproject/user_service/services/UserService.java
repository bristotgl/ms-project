package io.github.bristotgl.msproject.user_service.services;

import io.github.bristotgl.msproject.user_service.dtos.UserRequest;
import io.github.bristotgl.msproject.user_service.models.User;
import io.github.bristotgl.msproject.user_service.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        return userRepository.save(user);
    }


}
