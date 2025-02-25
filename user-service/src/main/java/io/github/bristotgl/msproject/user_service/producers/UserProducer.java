package io.github.bristotgl.msproject.user_service.producers;

import io.github.bristotgl.msproject.user_service.dtos.EmailDto;
import io.github.bristotgl.msproject.user_service.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        String text = "rall elorim is a beautiful, royal and regal place";
        String subject = "about rall elorim";
        EmailDto emailDto = new EmailDto(user.getUserId(), user.getEmail(), text, subject);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
