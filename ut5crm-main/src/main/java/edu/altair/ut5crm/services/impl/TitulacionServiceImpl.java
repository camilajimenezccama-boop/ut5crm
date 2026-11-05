package edu.altair.ut5crm.services.impl;

import edu.altair.ut5crm.dtos.TitulacionRequestDto;
import edu.altair.ut5crm.dtos.TitulacionResponseDto;
import edu.altair.ut5crm.entities.Titulacion;
import edu.altair.ut5crm.repositories.TitulacionRepository;
import edu.altair.ut5crm.services.TitulacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TitulacionServiceImpl implements TitulacionService {

    private final TitulacionRepository titulacionRepository;

    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
        this.titulacionRepository = titulacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TitulacionResponseDto> obtenerTodas() {
        return titulacionRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto obtenerPorId(Long id) {
        Titulacion titulacion = titulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la titulación con ID: " + id));
        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto obtenerPorCodigo(String codigo) {
        Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("No se encontró la titulación con código: " + codigo));
        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional(readOnly = true)
    public TitulacionResponseDto obtenerPorDiminutivo(String diminutivo) {
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() -> new RuntimeException("No se encontró la titulación con diminutivo: " + diminutivo));
        return mapToResponseDto(titulacion);
    }

    @Override
    @Transactional
    public TitulacionResponseDto crear(TitulacionRequestDto dto) {
        Titulacion titulacion = new Titulacion();
        titulacion.setCodigo(dto.codigo());
        titulacion.setDiminutivo(dto.diminutivo());
        titulacion.setHorasTotales(dto.horasTotales());

        Titulacion guardada = titulacionRepository.save(titulacion);
        return mapToResponseDto(guardada);
    }

    @Override
    @Transactional
    public TitulacionResponseDto actualizar(Long id, TitulacionRequestDto dto) {
        Titulacion titulacion = titulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la titulación con ID: " + id));

        titulacion.setCodigo(dto.codigo());
        titulacion.setDiminutivo(dto.diminutivo());
        titulacion.setHorasTotales(dto.horasTotales());

        Titulacion actualizada = titulacionRepository.save(titulacion);
        return mapToResponseDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!titulacionRepository.existsById(id)) {
            throw new RuntimeException("Imposible eliminar. Titulación no encontrada con ID: " + id);
        }
        titulacionRepository.deleteById(id);
    }

    private TitulacionResponseDto mapToResponseDto(Titulacion titulacion) {
        Set<String> diminutivosCursos = titulacion.getCursos() != null
                ? titulacion.getCursos().stream()
                .map(c -> c.getDiminutivo() + " - " + c.getDescripcion())
                .collect(Collectors.toSet())
                : Set.of();

        return new TitulacionResponseDto(
                titulacion.getIdTitulacion(),
                titulacion.getCodigo(),
                titulacion.getDiminutivo(),
                titulacion.getHorasTotales(),
                diminutivosCursos
        );
    }
}