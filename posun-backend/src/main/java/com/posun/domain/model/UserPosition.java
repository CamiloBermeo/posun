package com.posun.domain.model;

public enum UserPosition {

    // Administrativos
    OWNER,          // Dueño/Propietario
    MANAGER,        // Gerente/Encargado
    RECEPTIONIST,   // Recepcionista (maneja agenda pero no presta servicio)

    // Operativos (Los que prestan el servicio)
    SPECIALIST,     // Especialista / Profesional principal
    ASSISTANT,      // Asistente / Ayudante

    // Otros
    OTHER
}
