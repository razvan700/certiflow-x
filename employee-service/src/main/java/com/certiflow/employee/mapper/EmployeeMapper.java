package com.certiflow.employee.mapper;

import com.certiflow.employee.dto.EmployeeRequestDto;
import com.certiflow.employee.dto.EmployeeResponseDto;
import com.certiflow.employee.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "Spring")
public interface EmployeeMapper {
Employee toEntity(EmployeeRequestDto dto);

    EmployeeResponseDto toResponseDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(EmployeeRequestDto dto, @MappingTarget Employee entity);
}
