package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.CursoRequestDto;
import edu.altair.ut5crm.dtos.CursoResponseDto;
import edu.altair.ut5crm.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listar() {
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id));
    }

    @GetMapping("/diminutivo/{diminutivo}")
    public ResponseEntity<CursoResponseDto> buscarPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(cursoService.obtenerPorDiminutivo(diminutivo));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> actualizar(@PathVariable Long id, @RequestBody CursoRequestDto requestDto) {
        return ResponseEntity.ok(cursoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}