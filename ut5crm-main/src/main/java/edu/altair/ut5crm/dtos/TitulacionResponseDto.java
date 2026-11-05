package edu.altair.ut5crm.dtos;

import java.util.Set;

public record TitulacionResponseDto(
        Long idTitulacion,
        String codigo,
        String diminutivo,
        Long horasTotales,
        Set<String> diminutivosCursos
) {}