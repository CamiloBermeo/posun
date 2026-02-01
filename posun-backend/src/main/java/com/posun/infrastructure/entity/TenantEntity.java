package com.posun.infrastructure.entity;

import com.posun.domain.model.TenantConfig;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tenants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class TenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String businessName;
    @Column(nullable = false, unique = true, length = 50)
    private String assignedURL;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    private TenantConfigEntity tenantConfig;

}
