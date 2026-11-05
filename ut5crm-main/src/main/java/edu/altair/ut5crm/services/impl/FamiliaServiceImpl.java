package edu.altair.ut5crm.services.impl;

import edu.altair.ut5crm.dtos.FamiliaRequestDto;
import edu.altair.ut5crm.dtos.FamiliaResponseDto;
import edu.altair.ut5crm.entities.Familia;
import edu.altair.ut5crm.repositories.FamiliaRepository;
import edu.altair.ut5crm.services.FamiliaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamiliaServiceImpl implements FamiliaService {

    private final FamiliaRepository familiaRepository;

    public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FamiliaResponseDto> obtenerTodas() {
        return familiaRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public FamiliaResponseDto obtenerPorId(Long id) {
        Familia familia = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la familia con ID: " + id));
        return mapToResponseDto(familia);
    }

    @Override
    @Transactional(readOnly = true)
    public FamiliaResponseDto obtenerPorEmailPadre(String emailPadre) {
        Familia familia = familiaRepository.findByEmailPadre(emailPadre)
                .orElseThrow(() -> new RuntimeException("No se encontró la familia con email de padre: " + emailPadre));
        return mapToResponseDto(familia);
    }

    @Override
    @Transactional(readOnly = true)
    public FamiliaResponseDto obtenerPorEmailMadre(String emailMadre) {
        Familia familia = familiaRepository.findByEmailMadre(emailMadre)
                .orElseThrow(() -> new RuntimeException("No se encontró la familia con email de madre: " + emailMadre));
        return mapToResponseDto(familia);
    }

    @Override
    @Transactional
    public FamiliaResponseDto crear(FamiliaRequestDto dto) {
        Familia familia = new Familia();
        familia.setEmailPadre(dto.emailPadre());
        familia.setEmailMadre(dto.emailMadre());
        familia.setTelefonoPadre(dto.telefonoPadre());
        familia.setTelefonoMadre(dto.telefonoMadre());

        Familia guardada = familiaRepository.save(familia);
        return mapToResponseDto(guardada);
    }

    @Override
    @Transactional
    public FamiliaResponseDto actualizar(Long id, FamiliaRequestDto dto) {
        Familia familia = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la familia con ID: " + id));

        familia.setEmailPadre(dto.emailPadre());
        familia.setEmailMadre(dto.emailMadre());
        familia.setTelefonoPadre(dto.telefonoPadre());
        familia.setTelefonoMadre(dto.telefonoMadre());

        Familia actualizada = familiaRepository.save(familia);
        return mapToResponseDto(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!familiaRepository.existsById(id)) {
            throw new RuntimeException("Imposible eliminar. Familia no encontrada con ID: " + id);
        }
        familiaRepository.deleteById(id);
    }

    private FamiliaResponseDto mapToResponseDto(Familia familia) {
        return new FamiliaResponseDto(
                familia.getIdFamilia(),
                familia.getEmailPadre(),
                familia.getEmailMadre(),
                familia.getTelefonoPadre(),
                familia.getTelefonoMadre()
        );
    }
}