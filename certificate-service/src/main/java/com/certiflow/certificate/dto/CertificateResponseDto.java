package com.certiflow.certificate.dto;


import java.time.LocalDate;
import java.util.UUID;

public record CertificateResponseDto(
        UUID id,
        String name,
        String issuer,
        LocalDate issuedAt,
        LocalDate expiresAt,
        UUID employeeId
) {}
