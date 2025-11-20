package com.certiflow.certificate.entity;

import com.certiflow.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "certificates")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Certificate extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String issuer;

    private LocalDate issuedAt;

    private LocalDate expiresAt;

    @Column(nullable = false)
    private UUID employeeId;
}
