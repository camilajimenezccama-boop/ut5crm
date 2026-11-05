package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.DepartamentoRequestDto;
import edu.altair.ut5crm.dtos.DepartamentoResponseDto;
import edu.altair.ut5crm.services.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> listar() {
        return ResponseEntity.ok(departamentoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.obtenerPorId(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(departamentoService.obtenerPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> actualizar(@PathVariable Long id, @RequestBody DepartamentoRequestDto requestDto) {
        return ResponseEntity.ok(departamentoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}