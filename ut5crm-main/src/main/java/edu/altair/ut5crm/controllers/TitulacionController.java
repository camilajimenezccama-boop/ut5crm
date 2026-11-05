package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.TitulacionRequestDto;
import edu.altair.ut5crm.dtos.TitulacionResponseDto;
import edu.altair.ut5crm.services.TitulacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titulaciones")
public class TitulacionController {

    private final TitulacionService titulacionService;

    public TitulacionController(TitulacionService titulacionService) {
        this.titulacionService = titulacionService;
    }

    @GetMapping
    public ResponseEntity<List<TitulacionResponseDto>> listar() {
        return ResponseEntity.ok(titulacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(titulacionService.obtenerPorId(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<TitulacionResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(titulacionService.obtenerPorCodigo(codigo));
    }

    @GetMapping("/diminutivo/{diminutivo}")
    public ResponseEntity<TitulacionResponseDto> buscarPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(titulacionService.obtenerPorDiminutivo(diminutivo));
    }

    @PostMapping
    public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(titulacionService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> actualizar(@PathVariable Long id, @RequestBody TitulacionRequestDto requestDto) {
        return ResponseEntity.ok(titulacionService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        titulacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}