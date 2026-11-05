package edu.altair.ut5crm.dtos;

public record AlumnoRequestDto(
        String nombre,
        String apellido,
        String dni,
        String numeroSS,
        String emailPersonal,
        String telefonoPersonal,
        String fechaAlta,
        String fechaBaja,
        String emailCentro
) {}