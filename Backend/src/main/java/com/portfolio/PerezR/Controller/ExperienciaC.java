package com.portfolio.PerezR.Controller;

import com.portfolio.PerezR.Dto.ExperienciaDto;
import com.portfolio.PerezR.Entity.Experiencia;
import com.portfolio.PerezR.Security.Controller.Mensaje;
import com.portfolio.PerezR.Service.ExperienciaServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaC {
    @Autowired
    ExperienciaServ expServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id")Integer id){
        if(!expServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!expServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        expServ.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreExp())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(expServ.existsByNombreExp(dtoexp.getNombreExp())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(
                dtoexp.getNombreExp(), dtoexp.getDescripExp(), dtoexp.getInicioExp(), dtoexp.getFinExp());
        expServ.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ExperienciaDto dtoexp){
        if(!expServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(expServ.existsByNombreExp(dtoexp.getNombreExp()) && expServ.getByNombreExp(dtoexp.getNombreExp()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoexp.getNombreExp())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = expServ.getOne(id).get();
        
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setDescripExp(dtoexp.getDescripExp());
        experiencia.setInicioExp(dtoexp.getInicioExp());
        experiencia.setFinExp(dtoexp.getFinExp());
        
        expServ.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
