package com.posun.infrastructure.entity;

import com.posun.domain.valueObject.ServiceType.DescriptionServiceVO;
import com.posun.domain.valueObject.ServiceType.NameServiceVO;
import com.posun.domain.valueObject.ServiceType.PriceVO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class ServiceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long tenantId;

    @Column(nullable = false, length = 100)
    private String nameService;

    @Column(length = 500)
    private String descriptionService;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(nullable = false)
    private boolean active;

}
