package edu.altair.ut5crm.dtos;

import java.util.Set;

public record AlumnoResponseDto(
        Long idAlumno,
        String nombre,
        String apellido,
        String dni,
        String numeroSS,
        String emailPersonal,
        String telefonoPersonal,
        String fechaAlta,
        String fechaBaja,
        String emailCentro,
        String nombreEstado,
        Set<String> codigosModulos
) {}