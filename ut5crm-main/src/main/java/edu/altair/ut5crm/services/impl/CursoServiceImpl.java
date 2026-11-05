package edu.altair.ut5crm.services.impl;

import edu.altair.ut5crm.dtos.CursoRequestDto;
import edu.altair.ut5crm.dtos.CursoResponseDto;
import edu.altair.ut5crm.entities.Curso;
import edu.altair.ut5crm.entities.Titulacion;
import edu.altair.ut5crm.repositories.CursoRepository;
import edu.altair.ut5crm.repositories.TitulacionRepository;
import edu.altair.ut5crm.services.CursoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final TitulacionRepository titulacionRepository;

    public CursoServiceImpl(CursoRepository cursoRepository, TitulacionRepository titulacionRepository) {
        this.cursoRepository = cursoRepository;
        this.titulacionRepository = titulacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CursoResponseDto> obtenerTodos() {
        return cursoRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CursoResponseDto obtenerPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el curso con ID: " + id));
        return mapToResponseDto(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public CursoResponseDto obtenerPorDiminutivo(String diminutivo) {
        Curso curso = cursoRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() -> new RuntimeException("No se encontró el curso con diminutivo: " + diminutivo));
        return mapToResponseDto(curso);
    }

    @Override
    @Transactional
    public CursoResponseDto crear(CursoRequestDto dto) {
        Curso curso = new Curso();
        curso.setDiminutivo(dto.diminutivo());
        curso.setDescripcion(dto.descripcion());

        if (dto.idTitulacion() != null) {
            Titulacion titulacion = titulacionRepository.findById(dto.idTitulacion())
                    .orElseThrow(() -> new RuntimeException("Titulación no encontrada con ID: " + dto.idTitulacion()));
            curso.setTitulacion(titulacion);
        }

        Curso guardado = cursoRepository.save(curso);
        return mapToResponseDto(guardado);
    }

    @Override
    @Transactional
    public CursoResponseDto actualizar(Long id, CursoRequestDto dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el curso con ID: " + id));

        curso.setDiminutivo(dto.diminutivo());
        curso.setDescripcion(dto.descripcion());

        if (dto.idTitulacion() != null) {
            Titulacion titulacion = titulacionRepository.findById(dto.idTitulacion())
                    .orElseThrow(() -> new RuntimeException("Titulación no encontrada con ID: " + dto.idTitulacion()));
            curso.setTitulacion(titulacion);
        } else {
            curso.setTitulacion(null);
        }

        Curso actualizado = cursoRepository.save(curso);
        return mapToResponseDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Imposible eliminar. Curso no encontrado con ID: " + id);
        }
        cursoRepository.deleteById(id);
    }

    private CursoResponseDto mapToResponseDto(Curso curso) {
        String nombreTitulacion = (curso.getTitulacion() != null) ? curso.getTitulacion().getCodigo() : "SIN_TITULACION";

        Set<String> codigosModulos = curso.getModulos() != null
                ? curso.getModulos().stream()
                .map(m -> m.getCodigo() + " - " + m.getNombre())
                .collect(Collectors.toSet())
                : Set.of();

        return new CursoResponseDto(
                curso.getIdCurso(),
                curso.getDiminutivo(),
                curso.getDescripcion(),
                nombreTitulacion,
                codigosModulos
        );
    }
}