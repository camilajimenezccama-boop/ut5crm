package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.ModuloRequestDto;
import edu.altair.ut5crm.dtos.ModuloResponseDto;
import java.util.List;

public interface ModuloService {
    List<ModuloResponseDto> obtenerTodos();
    ModuloResponseDto obtenerPorId(Long id);
    ModuloResponseDto obtenerPorCodigo(String codigo);
    ModuloResponseDto crear(ModuloRequestDto requestDto);
    ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto);
    void eliminar(Long id);
}