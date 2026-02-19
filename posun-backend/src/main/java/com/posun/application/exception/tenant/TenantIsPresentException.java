package com.posun.application.exception.tenant;

public class TenantIsPresentException extends RuntimeException{

    public  TenantIsPresentException(String businessName){
        super("Y existe registrado un negocio con este nombre: " + businessName);
    }
}
