package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.ProfesorRequestDto;
import edu.altair.ut5crm.dtos.ProfesorResponseDto;
import edu.altair.ut5crm.services.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponseDto>> listar() {
        return ResponseEntity.ok(profesorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.obtenerPorId(id));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<ProfesorResponseDto> buscarPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(profesorService.obtenerPorDni(dni));
    }

    @PostMapping
    public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> actualizar(@PathVariable Long id, @RequestBody ProfesorRequestDto requestDto) {
        return ResponseEntity.ok(profesorService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}