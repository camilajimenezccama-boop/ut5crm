package edu.altair.ut5crm.repositories;

import edu.altair.ut5crm.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    // Clave candidata: código
    Optional<Departamento> findByCodigo(String codigo);
}