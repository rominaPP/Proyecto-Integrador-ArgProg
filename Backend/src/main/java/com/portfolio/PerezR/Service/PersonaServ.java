package com.portfolio.PerezR.Service;

import com.portfolio.PerezR.Entity.Persona;
import com.portfolio.PerezR.Interface.IPersonaServ;
import com.portfolio.PerezR.Repository.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServ implements IPersonaServ{
    @Autowired 
    private PersonaRepo PerRep;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = PerRep.findAll();
        return persona;    
    }

    @Override
    public void savePersona(Persona persona) {
        PerRep.save(persona);    
    }

    @Override
    public void deletePersona(Long id) {
        PerRep.deleteById(id);    
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = PerRep.findById(id).orElse(null);
        return persona;    
    }
}
