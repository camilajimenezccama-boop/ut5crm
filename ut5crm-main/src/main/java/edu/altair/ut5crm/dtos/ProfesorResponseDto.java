package edu.altair.ut5crm.dtos;

import java.util.Set;

public record ProfesorResponseDto(
        Long idProfesor,
        String nombre,
        String apellidos,
        String dni,
        String emailCentro,
        String emailPersonal,
        String telefonoPersonal,
        String codigoDepartamento,
        Set<String> codigosModulos
) {}