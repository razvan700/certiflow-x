package com.certiflow.employee.dto;

import java.util.UUID;

public record EmployeeEventDto (
    UUID id,
    String type,
    String firstName,
    String lastName,
    String email,
    String department,
    boolean active
) {}
