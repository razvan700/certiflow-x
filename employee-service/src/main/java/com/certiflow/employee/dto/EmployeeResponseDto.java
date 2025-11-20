package com.certiflow.employee.dto;


import java.util.UUID;

public record EmployeeResponseDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String department,
        Boolean active
) {}