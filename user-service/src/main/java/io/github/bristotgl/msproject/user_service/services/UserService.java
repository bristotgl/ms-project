package io.github.bristotgl.msproject.user_service.services;

import io.github.bristotgl.msproject.user_service.dtos.UserRequest;
import io.github.bristotgl.msproject.user_service.models.User;
import io.github.bristotgl.msproject.user_service.producers.UserProducer;
import io.github.bristotgl.msproject.user_service.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        User savedUser = userRepository.save(user);
        userProducer.publishMessageEmail(user);

        return savedUser;
    }


}
