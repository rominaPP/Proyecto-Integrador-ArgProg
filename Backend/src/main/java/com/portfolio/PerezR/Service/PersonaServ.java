package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Persona;
import com.portfolio.PerezR.Interface.IPersonaServ;
import com.portfolio.PerezR.Repository.PersonaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServ implements IPersonaServ{
    @Autowired 
    private PersonaRepo PerRep;

    @Override
    public List<Persona> list() {
        return PerRep.findAll();    
    }

    @Override
    public Optional<Persona> getOne(Integer id) {
        return PerRep.findById(id);    
    }

    @Override
    public Optional<Persona> getByNombre(String nombre) {
        return PerRep.findByNombre(nombre);    
    }

    @Override
    public void save(Persona persona) {
        PerRep.save(persona);    
    }

    @Override
    public void delete(Integer id) {
        PerRep.deleteById(id);    
    }

    @Override
    public boolean existsById(Integer id) {
        return PerRep.existsById(id);    
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return PerRep.existsByNombre(nombre);    
    }
    
}
