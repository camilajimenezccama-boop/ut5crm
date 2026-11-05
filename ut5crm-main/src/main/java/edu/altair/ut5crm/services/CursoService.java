package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.CursoRequestDto;
import edu.altair.ut5crm.dtos.CursoResponseDto;
import java.util.List;

public interface CursoService {
    List<CursoResponseDto> obtenerTodos();
    CursoResponseDto obtenerPorId(Long id);
    CursoResponseDto obtenerPorDiminutivo(String diminutivo);
    CursoResponseDto crear(CursoRequestDto requestDto);
    CursoResponseDto actualizar(Long id, CursoRequestDto requestDto);
    void eliminar(Long id);
}