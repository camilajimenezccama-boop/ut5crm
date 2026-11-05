package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.ModuloRequestDto;
import edu.altair.ut5crm.dtos.ModuloResponseDto;
import edu.altair.ut5crm.services.ModuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping
    public ResponseEntity<List<ModuloResponseDto>> listar() {
        return ResponseEntity.ok(moduloService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(moduloService.obtenerPorId(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ModuloResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(moduloService.obtenerPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moduloService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> actualizar(@PathVariable Long id, @RequestBody ModuloRequestDto requestDto) {
        return ResponseEntity.ok(moduloService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        moduloService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}