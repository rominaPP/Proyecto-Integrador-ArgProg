package com.portfolio.PerezR.Repository;

import com.portfolio.PerezR.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
}
