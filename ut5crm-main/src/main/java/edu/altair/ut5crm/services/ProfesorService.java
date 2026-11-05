package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.ProfesorRequestDto;
import edu.altair.ut5crm.dtos.ProfesorResponseDto;
import java.util.List;

public interface ProfesorService {
    List<ProfesorResponseDto> obtenerTodos();
    ProfesorResponseDto obtenerPorId(Long id);
    ProfesorResponseDto obtenerPorDni(String dni);
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
    void eliminar(Long id);
}