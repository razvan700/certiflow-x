package com.certiflow.certificate.repository;

import com.certiflow.certificate.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CertificateRepository extends JpaRepository<Certificate, UUID> {

    List<Certificate> findByEmployeeId(UUID employeeId);
}
