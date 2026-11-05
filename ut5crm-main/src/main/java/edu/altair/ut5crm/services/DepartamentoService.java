package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.DepartamentoRequestDto;
import edu.altair.ut5crm.dtos.DepartamentoResponseDto;
import java.util.List;

public interface DepartamentoService {
    List<DepartamentoResponseDto> obtenerTodos();
    DepartamentoResponseDto obtenerPorId(Long id);
    DepartamentoResponseDto obtenerPorCodigo(String codigo);
    DepartamentoResponseDto crear(DepartamentoRequestDto requestDto);
    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto);
    void eliminar(Long id);
}