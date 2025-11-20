package com.certiflow.certificate.mapper;

import com.certiflow.certificate.dto.CertificateRequestDto;
import com.certiflow.certificate.dto.CertificateResponseDto;
import com.certiflow.certificate.entity.Certificate;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    Certificate toEntity(CertificateRequestDto dto);

    CertificateResponseDto toResponseDto(Certificate certificate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(CertificateRequestDto dto, @MappingTarget Certificate certificate);
}
