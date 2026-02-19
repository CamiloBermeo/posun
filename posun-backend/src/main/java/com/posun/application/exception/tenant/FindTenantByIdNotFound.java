package com.posun.application.exception.tenant;

public class FindTenantByIdNotFound extends RuntimeException{
    public FindTenantByIdNotFound(Long id){
        super("En la base de datos no se registra un tenant con este id: " + id);
    }
}
