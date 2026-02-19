package com.posun.application.exception.tenant;

public class TenantNotFoundException extends RuntimeException{
    public TenantNotFoundException(String businessName){
        super("No se encontro este tenant: " + businessName + " en la base de datos");
    }
}
