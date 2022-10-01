package com.portfolio.PerezR.Repository;

import com.portfolio.PerezR.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepo extends JpaRepository<Redes, Integer>{
    public Optional<Redes> findByNombreR(String nombreR);
    public boolean existsByNombreR(String nombreR);
}
