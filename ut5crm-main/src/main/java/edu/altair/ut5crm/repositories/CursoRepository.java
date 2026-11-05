package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Búsqueda por clave candidata: diminutivo
    Optional<Curso> findByDiminutivo(String diminutivo);

    boolean existsByDiminutivo(String diminutivo);
}