package edu.altair.ut5crm.dtos;

public record FamiliaRequestDto(
        String emailPadre,
        String emailMadre,
        String telefonoPadre,
        String telefonoMadre
) {}