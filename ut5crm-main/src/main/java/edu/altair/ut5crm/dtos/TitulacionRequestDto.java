package edu.altair.ut5crm.dtos;

public record TitulacionRequestDto(
        String codigo,
        String diminutivo,
        Long horasTotales
) {}