package com.certiflow.employee.mapper;

import com.certiflow.employee.dto.EmployeeRequestDto;
import com.certiflow.employee.dto.EmployeeResponseDto;
import com.certiflow.employee.entity.Employee;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-21T04:38:39+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        return employee;
    }

    @Override
    public EmployeeResponseDto toResponseDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        UUID id = null;

        id = employee.getId();

        String firstName = null;
        String lastName = null;
        String email = null;
        String department = null;
        Boolean active = null;

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto( id, firstName, lastName, email, department, active );

        return employeeResponseDto;
    }

    @Override
    public void updateEntityFromDto(EmployeeRequestDto dto, Employee entity) {
        if ( dto == null ) {
            return;
        }
    }
}
