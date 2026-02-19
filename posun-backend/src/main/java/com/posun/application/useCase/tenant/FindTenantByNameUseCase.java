package com.posun.application.useCase.tenant;

import com.posun.application.exception.tenant.TenantNotFoundException;
import com.posun.domain.model.Tenant;
import com.posun.domain.repository.ITenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTenantByNameUseCase {

    private final ITenantRepository repository;

    public Tenant execute (String businessName){
        return repository.findByName(businessName)
                .orElseThrow(() -> new TenantNotFoundException(businessName));
    }

}
