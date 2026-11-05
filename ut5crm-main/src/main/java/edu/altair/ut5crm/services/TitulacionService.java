package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.TitulacionRequestDto;
import edu.altair.ut5crm.dtos.TitulacionResponseDto;
import java.util.List;

public interface TitulacionService {
    List<TitulacionResponseDto> obtenerTodas();
    TitulacionResponseDto obtenerPorId(Long id);
    TitulacionResponseDto obtenerPorCodigo(String codigo);
    TitulacionResponseDto obtenerPorDiminutivo(String diminutivo);
    TitulacionResponseDto crear(TitulacionRequestDto requestDto);
    TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto);
    void eliminar(Long id);
}