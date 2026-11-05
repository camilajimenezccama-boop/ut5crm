package edu.altair.ut5crm.dtos;

import java.util.Set;

public record ModuloResponseDto(
        Long idModulo,
        String codigo,
        String diminutivo,
        String nombre,
        String descripcion,
        Long horasSemanales,
        Long creditos,
        Set<String> nombresAlumnos
) {}