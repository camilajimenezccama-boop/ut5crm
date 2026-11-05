package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.FamiliaRequestDto;
import edu.altair.ut5crm.dtos.FamiliaResponseDto;
import edu.altair.ut5crm.services.FamiliaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    private final FamiliaService familiaService;

    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping
    public ResponseEntity<List<FamiliaResponseDto>> listar() {
        return ResponseEntity.ok(familiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(familiaService.obtenerPorId(id));
    }

    @GetMapping("/email-padre/{email}")
    public ResponseEntity<FamiliaResponseDto> buscarPorEmailPadre(@PathVariable String email) {
        return ResponseEntity.ok(familiaService.obtenerPorEmailPadre(email));
    }

    @GetMapping("/email-madre/{email}")
    public ResponseEntity<FamiliaResponseDto> buscarPorEmailMadre(@PathVariable String email) {
        return ResponseEntity.ok(familiaService.obtenerPorEmailMadre(email));
    }

    @PostMapping
    public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.crear(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> actualizar(@PathVariable Long id, @RequestBody FamiliaRequestDto requestDto) {
        return ResponseEntity.ok(familiaService.actualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        familiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}