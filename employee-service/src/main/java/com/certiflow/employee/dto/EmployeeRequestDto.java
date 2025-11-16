package com.certiflow.employee.dto;

public record EmployeeRequestDto(
        String firstName,
        String lastName,
        String email,
        String department,
        Boolean active
) {}
