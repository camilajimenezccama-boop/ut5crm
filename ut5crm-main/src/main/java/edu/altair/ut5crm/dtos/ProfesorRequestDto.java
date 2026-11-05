package edu.altair.ut5crm.dtos;

public record ProfesorRequestDto(
        String nombre,
        String apellidos,
        String dni,
        String emailCentro,
        String emailPersonal,
        String telefonoPersonal,
        Long idDepartamento
) {}