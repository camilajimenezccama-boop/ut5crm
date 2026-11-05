package edu.altair.ut5crm.controllers;

import edu.altair.ut5crm.dtos.AlumnoRequestDto;
import edu.altair.ut5crm.dtos.AlumnoResponseDto;
import edu.altair.ut5crm.services.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Listado paginado (GET /api/alumnos?page=0&size=10&sort=apellido,asc)
    @GetMapping
    public ResponseEntity<Page<AlumnoResponseDto>> obtenerTodosPaginado(
            @PageableDefault(page = 0, size = 10, sort = "apellido", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(alumnoService.obtenerTodosPaginado(pageable));
    }

    // Búsqueda por ID (PK)
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id));
    }

    // Búsqueda por DNI (Clave Candidata 1)
    @GetMapping("/dni/{dni}")
    public ResponseEntity<AlumnoResponseDto> buscarPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(alumnoService.obtenerPorDni(dni));
    }

    // Búsqueda por Número de la Seguridad Social (Clave Candidata 2)
    @GetMapping("/nss/{numeroSS}")
    public ResponseEntity<AlumnoResponseDto> buscarPorNumeroSS(@PathVariable String numeroSS) {
        return ResponseEntity.ok(alumnoService.obtenerPorNumeroSS(numeroSS));
    }

    // Crear Alumno
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.crear(requestDto));
    }

    // Actualizar Alumno
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(@PathVariable Long id, @RequestBody AlumnoRequestDto requestDto) {
        return ResponseEntity.ok(alumnoService.actualizar(id, requestDto));
    }

    // Borrar Alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}