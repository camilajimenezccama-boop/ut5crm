package edu.altair.ut5crm.dtos;

public record ModuloRequestDto(
        String codigo,
        String diminutivo,
        String nombre,
        String descripcion,
        Long horasSemanales,
        Long creditos
) {}