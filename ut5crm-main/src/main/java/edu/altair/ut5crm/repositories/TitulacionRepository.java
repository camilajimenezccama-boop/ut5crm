package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Titulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> {

    // Búsqueda por clave candidata: código
    Optional<Titulacion> findByCodigo(String codigo);

    // Búsqueda por clave candidata: diminutivo
    Optional<Titulacion> findByDiminutivo(String diminutivo);

    boolean existsByCodigo(String codigo);
}