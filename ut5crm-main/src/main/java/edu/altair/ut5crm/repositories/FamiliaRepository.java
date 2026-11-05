package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    // Búsqueda por email del padre (clave de contacto única orientativa)
    Optional<Familia> findByEmailPadre(String emailPadre);

    // Búsqueda por email de la madre
    Optional<Familia> findByEmailMadre(String emailMadre);
}