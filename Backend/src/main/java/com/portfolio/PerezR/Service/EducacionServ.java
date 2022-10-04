package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Educacion;
import com.portfolio.PerezR.Repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionServ {
    @Autowired
    EducacionRepo eduRepo;
    
    public List<Educacion> list(){
        return eduRepo.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return eduRepo.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion educacion){
        eduRepo.save(educacion);
    }
    
    public void delete(int id){
        eduRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRepo.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return eduRepo.existsByNombreEdu(nombreEdu);
    }
}
