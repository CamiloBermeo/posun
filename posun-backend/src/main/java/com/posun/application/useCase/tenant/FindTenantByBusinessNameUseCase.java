package com.posun.application.useCase.tenant;

import com.posun.domain.model.Tenant;
import com.posun.domain.repository.ITenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindTenantByBusinessNameUseCase {

    private final ITenantRepository repository;

    public Optional<Tenant> execute(String businessName) {
        return repository.findTenantByBusinessName(businessName);
    }

}
