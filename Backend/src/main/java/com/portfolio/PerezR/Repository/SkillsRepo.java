package com.portfolio.PerezR.Repository;

import com.portfolio.PerezR.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<Skill, Integer>{
    public Optional<Skill> findByNombreHyS(String nombreHyS);
    public boolean existsByNombreHyS(String nombreHyS);
}
