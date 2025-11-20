package com.certiflow.certificate.controller;


import com.certiflow.certificate.dto.CertificateRequestDto;
import com.certiflow.certificate.dto.CertificateResponseDto;
import com.certiflow.certificate.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @GetMapping
    public ResponseEntity<List<CertificateResponseDto>> getAllCertificates() {
        return ResponseEntity.ok(certificateService.getAllCertificates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificateResponseDto> getCertificate(@PathVariable UUID id) {
        return ResponseEntity.ok(certificateService.getCertificate(id));
    }

    @PostMapping
    public ResponseEntity<CertificateResponseDto> createCertificate(
            @RequestBody CertificateRequestDto dto
    ) {
        return ResponseEntity.status(201).body(certificateService.createCertificate(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificateResponseDto> updateCertificate(
            @PathVariable UUID id,
            @RequestBody CertificateRequestDto dto
    ) {
        return ResponseEntity.ok(certificateService.updateCertificate(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable UUID id) {
        certificateService.deleteCertificate(id);
        return ResponseEntity.noContent().build();
    }
}