package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.FamiliaRequestDto;
import edu.altair.ut5crm.dtos.FamiliaResponseDto;
import java.util.List;

public interface FamiliaService {
    List<FamiliaResponseDto> obtenerTodas();
    FamiliaResponseDto obtenerPorId(Long id);
    FamiliaResponseDto obtenerPorEmailPadre(String emailPadre);
    FamiliaResponseDto obtenerPorEmailMadre(String emailMadre);
    FamiliaResponseDto crear(FamiliaRequestDto requestDto);
    FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto);
    void eliminar(Long id);
}