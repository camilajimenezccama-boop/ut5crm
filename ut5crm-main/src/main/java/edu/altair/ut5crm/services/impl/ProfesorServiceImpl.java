package edu.altair.ut5crm.services.impl;

import edu.altair.ut5crm.dtos.ProfesorRequestDto;
import edu.altair.ut5crm.dtos.ProfesorResponseDto;
import edu.altair.ut5crm.entities.Departamento;
import edu.altair.ut5crm.entities.Profesor;
import edu.altair.ut5crm.repositories.DepartamentoRepository;
import edu.altair.ut5crm.repositories.ProfesorRepository;
import edu.altair.ut5crm.services.ProfesorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final DepartamentoRepository departamentoRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository, DepartamentoRepository departamentoRepository) {
        this.profesorRepository = profesorRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDto> obtenerTodos() {
        return profesorRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesorResponseDto obtenerPorId(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el profesor con ID: " + id));
        return mapToResponseDto(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesorResponseDto obtenerPorDni(String dni) {
        Profesor profesor = profesorRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("No se encontró el profesor con DNI: " + dni));
        return mapToResponseDto(profesor);
    }

    @Override
    @Transactional
    public ProfesorResponseDto crear(ProfesorRequestDto dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.nombre());
        profesor.setApellidos(dto.apellidos());
        profesor.setDni(dto.dni());
        profesor.setEmailCentro(dto.emailCentro());
        profesor.setEmailPersonal(dto.emailPersonal());
        profesor.setTelefonoPersonal(dto.telefonoPersonal());

        if (dto.idDepartamento() != null) {
            Departamento dep = departamentoRepository.findById(dto.idDepartamento())
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + dto.idDepartamento()));
            profesor.setDepartamento(dep);
        }

        Profesor guardado = profesorRepository.save(profesor);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto dto) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el profesor con ID: " + id));

        profesor.setNombre(dto.nombre());
        profesor.setApellidos(dto.apellidos());
        profesor.setDni(dto.dni());
        profesor.setEmailCentro(dto.emailCentro());
        profesor.setEmailPersonal(dto.emailPersonal());
        profesor.setTelefonoPersonal(dto.telefonoPersonal());

        if (dto.idDepartamento() != null) {
            Departamento dep = departamentoRepository.findById(dto.idDepartamento())
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + dto.idDepartamento()));
            profesor.setDepartamento(dep);
        } else {
            profesor.setDepartamento(null);
        }

        Profesor actualizado = profesorRepository.save(profesor);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new RuntimeException("Imposible eliminar. Profesor no encontrado con ID: " + id);
        }
        profesorRepository.deleteById(id);
    }

    private ProfesorResponseDto mapToResponseDto(Profesor profesor) {
        String codigoDep = (profesor.getDepartamento() != null) ? profesor.getDepartamento().getCodigo() : "SIN_DEPARTAMENTO";

        Set<String> codigosModulos = profesor.getModulos() != null
                ? profesor.getModulos().stream()
                .map(m -> m.getCodigo() + " - " + m.getNombre())
                .collect(Collectors.toSet())
                : Set.of();

        return new ProfesorResponseDto(
                profesor.getIdProfesor(),
                profesor.getNombre(),
                profesor.getApellidos(),
                profesor.getDni(),
                profesor.getEmailCentro(),
                profesor.getEmailPersonal(),
                profesor.getTelefonoPersonal(),
                codigoDep,
                codigosModulos
        );
    }
}