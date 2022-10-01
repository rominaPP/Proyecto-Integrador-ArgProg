package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Experiencia;
import com.portfolio.PerezR.Repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaServ {
    @Autowired
    ExperienciaRepo expRepo;
    
    public List<Experiencia> list(){
        return expRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(Integer id){
        return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return expRepo.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia experiencia){
        expRepo.save(experiencia);
    }
    
    public void delete(Integer id){
        expRepo.deleteById(id);
    }
    
    public boolean existsById(Integer id){
        return expRepo.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return expRepo.existsByNombreExp(nombreExp);
    }
}
