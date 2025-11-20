package com.certiflow.certificate.consumer;

import com.certiflow.certificate.service.CertificateService;
import com.certiflow.common.events.EmployeeEventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeEventConsumer {

    private final CertificateService certificateService;

    @RabbitListener(queues = "certificate.employee.created.queue")
    public void handleEmployeeCreated(EmployeeEventDto event) {
        log.info("Received employee created event: {}", event);

        certificateService.createInitialCertificates(event);
    }
}
