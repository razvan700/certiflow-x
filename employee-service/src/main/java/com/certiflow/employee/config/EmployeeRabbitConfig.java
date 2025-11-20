package com.certiflow.employee.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public class EmployeeRabbitConfig {

    public static final String EXCHANGE = "employee.exchange";
    public static final String EMPLOYEE_CREATED = "employee.created";
    public static final String EMPLOYEE_UPDATED = "employee.updated";

    @Bean
    public TopicExchange employeeExchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }
}
