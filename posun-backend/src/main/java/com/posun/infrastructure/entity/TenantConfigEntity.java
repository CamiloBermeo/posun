package com.posun.infrastructure.entity;

import com.posun.domain.valueObject.TenantConfig.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tenant_configs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class TenantConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenant;
    @Column(length = 7)
    private String primaryColor;
    @Column(length = 500)
    private String logoUrl;
    @Column(length = 500)
    private String faviconUrl;
    @Column(columnDefinition = "TEXT")
    private String welcomeMessage;
    @Column(nullable = false)
    private boolean allowsCancellation;
    @Column(nullable = false)
    private Integer cancellationMaxHours;


}
