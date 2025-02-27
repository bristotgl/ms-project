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
        String text = "some cool new thing about age of mythology";
        String subject = "ISVOLI Tuesday! ed. 34";
        EmailDto emailDto = new EmailDto(user.getUserId(), user.getEmail(), subject, text);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
