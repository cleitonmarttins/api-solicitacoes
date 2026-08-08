package br.com.cotiinformatica.api_solicitacoes.infrastructure.components;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducerComponent {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void sendMessage(String message) throws Exception {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
