package com.portfolio.PerezR.Interface;

import com.portfolio.PerezR.Entity.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaServ {
    public List<Persona> list();
    
    public Optional<Persona> getOne(Integer id);
    
    public Optional<Persona> getByNombre(String nombre);
    
    public void save(Persona persona);
    
    public void delete(Integer id);
    
    public boolean existsById(Integer id);
    
    public boolean existsByNombre(String nombre);
}
