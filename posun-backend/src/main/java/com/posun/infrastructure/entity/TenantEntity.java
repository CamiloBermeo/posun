package com.posun.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    @Builder.Default
    private boolean status = true;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    private TenantConfigEntity tenantConfig;
    @Builder.Default
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAdminEntity> userAdmins = new ArrayList<>();
    public void addAdmin(UserAdminEntity admin) {
        if (admin != null) {
            // 1. Inicializamos la lista si por algún motivo es nula (defensa)
            if (this.userAdmins == null) {
                this.userAdmins = new ArrayList<>();
            }

            // 2. Agregamos el admin a la colección del Tenant (Lado inverso)
            this.userAdmins.add(admin);

            // 3. ESTABLECEMOS EL TENANT EN EL ADMIN (Lado dueño - El que va a la DB)
            admin.setTenant(this);
        }
    }
}