package edu.altair.ut5crm.services.impl;

import edu.altair.ut5crm.dtos.AlumnoRequestDto;
import edu.altair.ut5crm.dtos.AlumnoResponseDto;
import edu.altair.ut5crm.entities.Alumno;
import edu.altair.ut5crm.repositories.AlumnoRepository;
import edu.altair.ut5crm.services.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AlumnoResponseDto> obtenerTodosPaginado(Pageable pageable) {
        Page<Alumno> paginaAlumnos = alumnoRepository.findAll(pageable);
        return paginaAlumnos.map(this::mapToResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto obtenerPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con ID: " + id));
        return mapToResponseDto(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto obtenerPorDni(String dni) {
        Alumno alumno = alumnoRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con DNI: " + dni));
        return mapToResponseDto(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDto obtenerPorNumeroSS(String numeroSS) {
        Alumno alumno = alumnoRepository.findByNumeroSS(numeroSS)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con Seguridad Social: " + numeroSS));
        return mapToResponseDto(alumno);
    }

    @Override
    @Transactional
    public AlumnoResponseDto crear(AlumnoRequestDto dto) {
        Alumno nuevo = new Alumno();
        nuevo.setNombre(dto.nombre());
        nuevo.setApellido(dto.apellido());
        nuevo.setDni(dto.dni());
        nuevo.setNumeroSS(dto.numeroSS());
        nuevo.setEmailPersonal(dto.emailPersonal());
        nuevo.setTelefonoPersonal(dto.telefonoPersonal());
        nuevo.setFechaAlta(dto.fechaAlta());
        nuevo.setFechaBaja(dto.fechaBaja());
        nuevo.setEmailCentro(dto.emailCentro());

        Alumno guardado = alumnoRepository.save(nuevo);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto dto) {
        Alumno existente = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con ID: " + id));

        existente.setNombre(dto.nombre());
        existente.setApellido(dto.apellido());
        existente.setDni(dto.dni());
        existente.setNumeroSS(dto.numeroSS());
        existente.setEmailPersonal(dto.emailPersonal());
        existente.setTelefonoPersonal(dto.telefonoPersonal());
        existente.setFechaAlta(dto.fechaAlta());
        existente.setFechaBaja(dto.fechaBaja());
        existente.setEmailCentro(dto.emailCentro());

        Alumno actualizado = alumnoRepository.save(existente);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Imposible eliminar. Alumno no encontrado con ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    // Mapeo defensivo a DTO dentro del contexto transaccional
    private AlumnoResponseDto mapToResponseDto(Alumno alumno) {
        String estado = (alumno.getEstado() != null) ? alumno.getEstado().getNombre() : "SIN_ESTADO";

        Set<String> codigosModulos = alumno.getModulos() != null
                ? alumno.getModulos().stream()
                .map(m -> m.getCodigo() + " - " + m.getNombre())
                .collect(Collectors.toSet())
                : Set.of();

        return new AlumnoResponseDto(
                alumno.getIdAlumno(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getDni(),
                alumno.getNumeroSS(),
                alumno.getEmailPersonal(),
                alumno.getTelefonoPersonal(),
                alumno.getFechaAlta(),
                alumno.getFechaBaja(),
                alumno.getEmailCentro(),
                estado,
                codigosModulos
        );
    }
}