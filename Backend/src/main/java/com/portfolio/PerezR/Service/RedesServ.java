package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Redes;
import com.portfolio.PerezR.Repository.RedesRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RedesServ {
    @Autowired
    RedesRepo redRepo;
    
    public List<Redes> list(){
        return redRepo.findAll();
    }
    
    public Optional<Redes> getOne(int id){
        return redRepo.findById(id);
    }
    
    public Optional<Redes> getByNombreR(String nombreR){
        return redRepo.findByNombreR(nombreR);
    }
    
    public void save(Redes redes){
        redRepo.save(redes);
    }
    
    public void delete(int id){
        redRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return redRepo.existsById(id);
    }
    
    public boolean existsByNombreR(String nombreR){
        return redRepo.existsByNombreR(nombreR);
    }
}
