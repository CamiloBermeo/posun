package com.posun.application.exception.valueObject;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(Double price) {
        super("El precio no puede ser negativo. Valor recibido:" + price );
    }
}
