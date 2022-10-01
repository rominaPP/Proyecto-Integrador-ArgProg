package com.portfolio.PerezR.Repository;

import com.portfolio.PerezR.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
}
