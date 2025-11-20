package com.certiflow.employee.event;

import com.certiflow.common.events.EmployeeEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishEvent(String routingKey, EmployeeEventDto event) {
        rabbitTemplate.convertAndSend(
                "employee.exchange",
                routingKey,
                event
        );
    }
}
