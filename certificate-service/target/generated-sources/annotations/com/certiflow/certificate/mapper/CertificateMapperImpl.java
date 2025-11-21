package com.certiflow.certificate.mapper;

import com.certiflow.certificate.dto.CertificateRequestDto;
import com.certiflow.certificate.dto.CertificateResponseDto;
import com.certiflow.certificate.entity.Certificate;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-21T04:38:41+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CertificateMapperImpl implements CertificateMapper {

    @Override
    public Certificate toEntity(CertificateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Certificate certificate = new Certificate();

        return certificate;
    }

    @Override
    public CertificateResponseDto toResponseDto(Certificate certificate) {
        if ( certificate == null ) {
            return null;
        }

        UUID id = null;

        id = certificate.getId();

        String name = null;
        String issuer = null;
        LocalDate issuedAt = null;
        LocalDate expiresAt = null;
        UUID employeeId = null;

        CertificateResponseDto certificateResponseDto = new CertificateResponseDto( id, name, issuer, issuedAt, expiresAt, employeeId );

        return certificateResponseDto;
    }

    @Override
    public void updateEntityFromDto(CertificateRequestDto dto, Certificate certificate) {
        if ( dto == null ) {
            return;
        }
    }
}
