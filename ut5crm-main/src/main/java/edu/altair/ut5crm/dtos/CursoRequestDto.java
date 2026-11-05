package edu.altair.ut5crm.dtos;

public record CursoRequestDto(
        String diminutivo,
        String descripcion,
        Long idTitulacion
) {}