package com.posun.application.exception.tenant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TenantNotFoundException extends RuntimeException{
    public TenantNotFoundException(String businessName){
        super("No se encontro este tenant: " + businessName + " en la base de datos");
    }
}
