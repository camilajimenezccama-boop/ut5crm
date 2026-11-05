package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.EstadoRequestDto;
import edu.altair.ut5crm.dtos.EstadoResponseDto;
import java.util.List;

public interface EstadoService {
    List<EstadoResponseDto> obtenerTodos();
    EstadoResponseDto obtenerPorId(Long id);
    EstadoResponseDto obtenerPorNombre(String nombre);
    EstadoResponseDto crear(EstadoRequestDto requestDto);
    EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto);
    void eliminar(Long id);
}