package com.portfolio.PerezR.Controller;

import com.portfolio.PerezR.Dto.PersonaDto;
import com.portfolio.PerezR.Entity.Persona;
import com.portfolio.PerezR.Interface.IPersonaServ;
import com.portfolio.PerezR.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/personas")
public class PersonaC {
     @Autowired IPersonaServ iPerServ;
               
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return iPerServ.getPersona();
    }
    
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return iPerServ.findPersona((long)2);
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPerServ.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody PersonaDto dtoper){
        
        Persona persona = new Persona(
                dtoper.getNombre(), dtoper.getApellido(), dtoper.getImg(), dtoper.getTitulo(), dtoper.getSobremi());
                     
        iPerServ.savePersona(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PersonaDto dtoper){
        Persona persona = iPerServ.findPersona(id);
        
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg(dtoper.getImg());
        persona.setTitulo(dtoper.getTitulo());
        persona.setSobremi(dtoper.getSobremi());
        
        iPerServ.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
