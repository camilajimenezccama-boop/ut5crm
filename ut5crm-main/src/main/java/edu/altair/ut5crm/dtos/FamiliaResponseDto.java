package edu.altair.ut5crm.dtos;

public record FamiliaResponseDto(
        Long idFamilia,
        String emailPadre,
        String emailMadre,
        String telefonoPadre,
        String telefonoMadre
) {}