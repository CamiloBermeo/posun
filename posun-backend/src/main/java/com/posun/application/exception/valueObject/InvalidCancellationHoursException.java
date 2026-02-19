package com.posun.application.exception.valueObject;

public class InvalidCancellationHoursException extends RuntimeException {
    public InvalidCancellationHoursException(int value) {
        super("Las horas máximas de cancelación no pueden ser negativas. Valor recibido: " + value);
    }
}
