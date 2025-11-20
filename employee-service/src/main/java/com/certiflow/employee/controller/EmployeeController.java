package com.certiflow.employee.controller;

import com.certiflow.employee.dto.EmployeeRequestDto;
import com.certiflow.employee.dto.EmployeeResponseDto;
import com.certiflow.employee.entity.Employee;
import com.certiflow.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDto createEmployee(@RequestBody EmployeeRequestDto employee) {
        return employeeService.createEmployee(employee);
    }

    @PatchMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateEmployee(@PathVariable UUID id) {
        employeeService.deactivateEmployee(id);
    }

    @PatchMapping("/{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateEmployee(@PathVariable UUID id) {
        employeeService.activateEmployee(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable UUID id, @RequestBody EmployeeRequestDto employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
