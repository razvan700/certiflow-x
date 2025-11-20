package com.certiflow.employee.service;

import com.certiflow.common.error.ApiException;
import com.certiflow.employee.dto.EmployeeEventDto;
import com.certiflow.employee.dto.EmployeeRequestDto;
import com.certiflow.employee.dto.EmployeeResponseDto;
import com.certiflow.employee.entity.Employee;
import com.certiflow.employee.event.EmployeeEventPublisher;
import com.certiflow.employee.mapper.EmployeeMapper;
import com.certiflow.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeEventPublisher eventPublisher;

    private final EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findByActiveTrue();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ApiException("Employee not found", 404));
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {

        employeeRepository.findByEmail(dto.email()).ifPresent(e -> {
            throw new ApiException("Email already in use", 400);
        });

        Employee employee = employeeMapper.toEntity(dto);

        Employee saved = employeeRepository.save(employee);

        eventPublisher.publishEvent(
                "employee.created",
                new EmployeeEventDto(
                        saved.getId(),
                        "employee.created",
                        saved.getFirstName(),
                        saved.getLastName(),
                        saved.getEmail(),
                        saved.getDepartment(),
                        saved.isActive()
                )
        );

        return employeeMapper.toResponseDto(saved);
    }

    public EmployeeResponseDto updateEmployee(UUID id, EmployeeRequestDto dto) {

        employeeRepository.findByEmail(dto.email()).ifPresent(existing -> {
            if (!existing.getId().equals(id)) {
                throw new ApiException("Email already in use by another employee", 400);
            }
        });

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ApiException("Employee not found", 404));

        employeeMapper.updateEntityFromDto(dto, existing);

        Employee saved = employeeRepository.save(existing);

        eventPublisher.publishEvent(
                "employee.updated",
                new EmployeeEventDto(
                        saved.getId(),
                        "employee.updated",
                        saved.getFirstName(),
                        saved.getLastName(),
                        saved.getEmail(),
                        saved.getDepartment(),
                        saved.isActive()
                )
        );

        return employeeMapper.toResponseDto(saved);
    }

    public void deactivateEmployee(UUID id) {
        Employee employee = getEmployeeById(id);
        if (!employee.isActive()) {
            throw new ApiException("Employee is already inactive", 400);
        }
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public void activateEmployee(UUID id) {
        Employee employee = getEmployeeById(id);
        if (employee.isActive()) {
            throw new ApiException("Employee is already active", 400);
        }
        employee.setActive(true);
        employeeRepository.save(employee);
    }
}
