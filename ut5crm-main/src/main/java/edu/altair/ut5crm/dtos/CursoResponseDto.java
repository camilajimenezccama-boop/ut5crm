package edu.altair.ut5crm.dtos;

import java.util.Set;

public record CursoResponseDto(
        Long idCurso,
        String diminutivo,
        String descripcion,
        String nombreTitulacion,
        Set<String> codigosModulos
) {}