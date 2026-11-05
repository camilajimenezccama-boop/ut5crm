package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    // Búsqueda por clave candidata o nombre único
    Optional<Estado> findByNombre(String nombre);
}