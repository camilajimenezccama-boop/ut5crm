package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // Búsqueda por clave candidata: DNI
    Optional<Profesor> findByDni(String dni);

    boolean existsByDni(String dni);
}