package com.certiflow.certificate.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EMPLOYEE_EXCHANGE = "employee.exchange";
    public static final String EMPLOYEE_CREATED_QUEUE = "certificate.employee.created.queue";

    @Bean
    public TopicExchange employeeExchange() {
        return new TopicExchange(EMPLOYEE_EXCHANGE, true, false);
    }

    @Bean
    public Queue employeeCreatedQueue() {
        return QueueBuilder
                .durable(EMPLOYEE_CREATED_QUEUE)
                .build();
    }

    @Bean
    public Binding bindEmployeeCreated() {
        return BindingBuilder
                .bind(employeeCreatedQueue())
                .to(employeeExchange())
                .with("employee.created");
    }
}
