package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Proyecto;
import com.portfolio.PerezR.Repository.ProyectoRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoServ {
    @Autowired
    ProyectoRepo proRepo;
    
    public List<Proyecto> list(){
        return proRepo.findAll();
    }
    
    public Optional<Proyecto> getOne(Integer id){
        return proRepo.findById(id);
    }
    
    public Optional<Proyecto> getByNombrePro(String nombrePro){
        return proRepo.findByNombrePro(nombrePro);
    }
    
    public void save(Proyecto proyecto){
        proRepo.save(proyecto);
    }
    
    public void delete(Integer id){
        proRepo.deleteById(id);
    }
    
    public boolean existsById(Integer id){
        return proRepo.existsById(id);
    }
    
    public boolean existsByNombrePro(String nombrePro){
        return proRepo.existsByNombrePro(nombrePro);
    }
}
