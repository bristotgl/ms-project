package io.github.bristotgl.msproject.email_service.consumers;

import io.github.bristotgl.msproject.email_service.dtos.EmailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto) {
        System.out.println(emailDto.emailTo());
    }
}
