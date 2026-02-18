package com.posun.application.useCase.tenant;

import com.posun.domain.model.Tenant;
import com.posun.domain.repository.ITenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindTenantByIdUseCase {
    private final ITenantRepository  repository;

    public Tenant execute (Long id){
         return repository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("No existe el tenant con ID: \" + id"));
    }

}
