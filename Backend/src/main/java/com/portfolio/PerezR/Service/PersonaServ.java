package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Persona;
import com.portfolio.PerezR.Repository.PersonaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServ {
    @Autowired 
    private PersonaRepo perRep;

    public List<Persona> list(){
        return perRep.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return perRep.findById(id);
    }
    
    public Optional<Persona> getByNombreExp(String nombre){
        return perRep.findByNombre(nombre);
    }
    
    public void save(Persona experiencia){
        perRep.save(experiencia);
    }
    
    public void delete(int id){
        perRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return perRep.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return perRep.existsByNombre(nombre);
    }
}
