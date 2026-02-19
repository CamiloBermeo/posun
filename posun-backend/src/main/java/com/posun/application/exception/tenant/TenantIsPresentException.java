package com.posun.application.exception.tenant;

public class TenantIsPresentException extends RuntimeException{

    public  TenantIsPresentException(String businessName){
        super("Ya existe registrado un negocio con este nombre: " + businessName);
    }
}
