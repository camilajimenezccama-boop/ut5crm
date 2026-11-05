package edu.altair.ut5crm.dtos;

import java.util.Set;

public record DepartamentoResponseDto(
        Long idDepartamento,
        String codigo,
        Set<String> nombresProfesores
) {}