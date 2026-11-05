package edu.altair.ut5crm.dtos;

import java.util.Set;

public record EstadoResponseDto(
        Long idEstado,
        String nombre,
        Set<String> nombresAlumnos
) {}