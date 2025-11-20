package com.certiflow.certificate.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CertificateRequestDto(
        String name,
        String issuer,
        LocalDate issuedAt,
        LocalDate expiresAt,
        UUID employeeId
) {}
