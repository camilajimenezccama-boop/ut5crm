package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    // Búsqueda por Clave Candidata: código
    Optional<Modulo> findByCodigo(String codigo);

    // Búsqueda por Clave Candidata: diminutivo
    Optional<Modulo> findByDiminutivo(String diminutivo);

    boolean existsByCodigo(String codigo);
}