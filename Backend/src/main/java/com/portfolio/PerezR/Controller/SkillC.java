package com.portfolio.PerezR.Controller;

import com.portfolio.PerezR.Dto.SkillsDto;
import com.portfolio.PerezR.Entity.Skill;
import com.portfolio.PerezR.Security.Controller.Mensaje;
import com.portfolio.PerezR.Service.SkillServ;
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
@RequestMapping("/hys")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillC {
    @Autowired
    SkillServ hysServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = hysServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id")Integer id){
        if(!hysServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = hysServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!hysServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        hysServ.delete(id);
        return new ResponseEntity(new Mensaje("Hard soft and skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillsDto dtohys){
        if(StringUtils.isBlank(dtohys.getNombreHyS())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(hysServ.existsByNombreHyS(dtohys.getNombreHyS())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = new Skill(
                dtohys.getNombreHyS(), dtohys.getPorcentaje()
            );
        hysServ.save(skill);
        return new ResponseEntity(new Mensaje("Hard soft and skill creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SkillsDto dtohys){
        if(!hysServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(hysServ.existsByNombreHyS(dtohys.getNombreHyS()) && hysServ.getByNombreHyS(dtohys.getNombreHyS()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohys.getNombreHyS())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = hysServ.getOne(id).get();
        
        skill.setNombreHyS(dtohys.getNombreHyS());
        skill.setPorcentaje(dtohys.getPorcentaje());
        
        hysServ.save(skill);
        
        return new ResponseEntity(new Mensaje("Hard soft and skill actualizada"), HttpStatus.OK);
    }
}
