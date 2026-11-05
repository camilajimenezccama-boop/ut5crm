package edu.altair.ut5crm.services;

import edu.altair.ut5crm.dtos.AlumnoRequestDto;
import edu.altair.ut5crm.dtos.AlumnoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlumnoService {
    Page<AlumnoResponseDto> obtenerTodosPaginado(Pageable pageable);
    AlumnoResponseDto obtenerPorId(Long id);
    AlumnoResponseDto obtenerPorDni(String dni);
    AlumnoResponseDto obtenerPorNumeroSS(String numeroSS);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    void eliminar(Long id);
}