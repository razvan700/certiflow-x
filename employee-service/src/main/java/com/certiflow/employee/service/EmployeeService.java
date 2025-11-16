package com.certiflow.employee.service;

import com.certiflow.common.error.ApiException;
import com.certiflow.employee.entity.Employee;
import com.certiflow.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findByActiveTrue();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ApiException("Employee not found", 404));
    }

    public Employee createEmployee(Employee employee) {
        employeeRepository.findByEmail(employee.getEmail()).ifPresent(e -> {
            throw new ApiException("Email already in use", 400);
        });
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(UUID id, Employee updated) {
        Employee existing = getEmployeeById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setDepartment(updated.getDepartment());
        existing.setEmail(updated.getEmail());
        existing.setLastName(updated.getLastName());
        existing.setActive(updated.isActive());
        return employeeRepository.save(existing);
    }

    public void deactivateEmployee(UUID id) {
        Employee employee = getEmployeeById(id);
        if (!employee.isActive()) {
            throw new ApiException("Employee is already inactive", 400);
        }
        employee.setActive(false);
        employeeRepository.save(employee);
    }
}
