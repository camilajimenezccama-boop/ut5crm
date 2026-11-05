package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.EstadoRequestDto;
import edu.altair.ut5crm.dtos.EstadoResponseDto;
import edu.altair.ut5crm.services.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoResponseDto>> listar() {
        return ResponseEntity.ok(estadoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.obtenerPorId(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<EstadoResponseDto> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(estadoService.obtenerPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<EstadoResponseDto> crear(@RequestBody EstadoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> actualizar(@PathVariable Long id, @RequestBody EstadoRequestDto requestDto) {
        return ResponseEntity.ok(estadoService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}