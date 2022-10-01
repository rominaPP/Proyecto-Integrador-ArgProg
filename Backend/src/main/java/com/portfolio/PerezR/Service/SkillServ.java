package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Skill;
import com.portfolio.PerezR.Repository.SkillsRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillServ {
    @Autowired
    SkillsRepo skRepo;
    
    public List<Skill> list(){
        return skRepo.findAll();
    }
    
    public Optional<Skill> getOne(Integer id){
        return skRepo.findById(id);
    }
    
    public Optional<Skill> getByNombreHyS(String nombreHyS){
        return skRepo.findByNombreHyS(nombreHyS);
    }
    
    public void save(Skill skill){
        skRepo.save(skill);
    }
    
    public void delete(Integer id){
        skRepo.deleteById(id);
    }
    
    public boolean existsById(Integer id){
        return skRepo.existsById(id);
    }
    
    public boolean existsByNombreHyS(String nombreHyS){
        return skRepo.existsByNombreHyS(nombreHyS);
    }
}
