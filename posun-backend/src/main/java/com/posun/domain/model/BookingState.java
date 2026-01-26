package com.posun.domain.model;

public enum BookingState {

    /**
     * La cita ha sido solicitada pero aún no confirmada por el negocio 
     * (Útil si quieres que el barbero apruebe manualmente).
     */
    PENDING,

    /**
     * La cita está confirmada y el espacio está bloqueado.
     */
    CONFIRMED,

    /**
     * El cliente asistió y el servicio se completó con éxito.
     */
    COMPLETED,

    /**
     * La cita fue cancelada (ya sea por el cliente o el negocio).
     */
    CANCELLED,

    /**
     * El cliente nunca llegó y no avisó (No-show). 
     * Crítico para analíticas y penalizaciones.
     */
    NOSHOW,

    /**
     * La cita quedó en PENDING y nunca se confirmó, o pasó la fecha sin acción.
     */
    EXPIRED

}
