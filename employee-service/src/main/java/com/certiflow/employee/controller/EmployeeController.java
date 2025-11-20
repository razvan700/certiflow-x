package com.certiflow.employee.controller;

import com.certiflow.employee.dto.EmployeeRequestDto;
import com.certiflow.employee.dto.EmployeeResponseDto;
import com.certiflow.employee.entity.Employee;
import com.certiflow.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable UUID id) {
        EmployeeResponseDto response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto response = employeeService.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateEmployee(@PathVariable UUID id) {
        employeeService.deactivateEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activateEmployee(@PathVariable UUID id) {
        employeeService.activateEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable UUID id,
            @RequestBody EmployeeRequestDto dto
    ) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }
}
