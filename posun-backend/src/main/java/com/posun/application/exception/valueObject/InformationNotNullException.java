package com.posun.application.exception.valueObject;

public class InformationNotNullException extends RuntimeException{
    public InformationNotNullException(String message){
        super("El campo " + message + " no puede estar vacio ");
    }
}
