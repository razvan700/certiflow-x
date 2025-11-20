package com.certiflow.certificate.service;

import com.certiflow.certificate.dto.CertificateRequestDto;
import com.certiflow.certificate.dto.CertificateResponseDto;
import com.certiflow.certificate.entity.Certificate;
import com.certiflow.certificate.mapper.CertificateMapper;
import com.certiflow.certificate.repository.CertificateRepository;
import com.certiflow.common.error.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final CertificateMapper mapper;

    public List<CertificateResponseDto> getAllCertificates() {
        return certificateRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public CertificateResponseDto getCertificate(UUID id) {
        return mapper.toResponseDto(findById(id));
    }

    public CertificateResponseDto createCertificate(CertificateRequestDto dto) {
        Certificate entity = mapper.toEntity(dto);
        Certificate saved = certificateRepository.save(entity);
        return mapper.toResponseDto(saved);
    }

    public CertificateResponseDto updateCertificate(UUID id, CertificateRequestDto dto) {
        Certificate existing = findById(id);
        mapper.updateEntityFromDto(dto, existing);
        Certificate saved = certificateRepository.save(existing);
        return mapper.toResponseDto(saved);
    }

    public void deleteCertificate(UUID id) {
        Certificate cert = findById(id);
        certificateRepository.delete(cert);
    }

    private Certificate findById(UUID id) {
        return certificateRepository.findById(id)
                .orElseThrow(() -> new ApiException("Certificate not found", 404));
    }
}
