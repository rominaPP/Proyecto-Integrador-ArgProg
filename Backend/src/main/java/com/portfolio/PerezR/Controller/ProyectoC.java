package com.portfolio.PerezR.Controller;

import com.portfolio.PerezR.Dto.ProyectoDto;
import com.portfolio.PerezR.Entity.Proyecto;
import com.portfolio.PerezR.Security.Controller.Mensaje;
import com.portfolio.PerezR.Service.ProyectoServ;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoC {
    @Autowired
    ProyectoServ proServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")Integer id){
        if(!proServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!proServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        proServ.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto dtopro){
        if(StringUtils.isBlank(dtopro.getNombrePro())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proServ.existsByNombrePro(dtopro.getNombrePro())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtopro.getNombrePro(), dtopro.getDescripPro(), dtopro.getInicioPro(), dtopro.getFinPro());
        proServ.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ProyectoDto dtopro){
        if(!proServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(proServ.existsByNombrePro(dtopro.getNombrePro()) && proServ.getByNombrePro(dtopro.getNombrePro()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopro.getNombrePro())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proServ.getOne(id).get();
        
        proyecto.setNombrePro(dtopro.getNombrePro());
        proyecto.setDescripPro(dtopro.getDescripPro());
        proyecto.setInicioPro(dtopro.getInicioPro());
        proyecto.setFinPro(dtopro.getFinPro());
        
        proServ.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
