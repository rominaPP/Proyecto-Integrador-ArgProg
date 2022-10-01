package com.portfolio.PerezR.Controller;

import com.portfolio.PerezR.Dto.RedesDto;
import com.portfolio.PerezR.Entity.Redes;
import com.portfolio.PerezR.Security.Controller.Mensaje;
import com.portfolio.PerezR.Service.RedesServ;
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
@RequestMapping("/redes")
@CrossOrigin(origins = "http://localhost:4200")
public class RedesC {
    @Autowired
    RedesServ redServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Redes>> list(){
        List<Redes> list = redServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id")Integer id){
        if(!redServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Redes redes = redServ.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!redServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        redServ.delete(id);
        return new ResponseEntity(new Mensaje("Red eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RedesDto dtored){
        if(StringUtils.isBlank(dtored.getNombreR())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(redServ.existsByNombreR(dtored.getNombreR())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Redes redes = new Redes(
                dtored.getNombreR(), dtored.getImg(), dtored.getLink());
        redServ.save(redes);
        return new ResponseEntity(new Mensaje("Red creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody RedesDto dtored){
        if(!redServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(redServ.existsByNombreR(dtored.getNombreR()) && redServ.getByNombreR(dtored.getNombreR()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtored.getNombreR())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Redes redes = redServ.getOne(id).get();
        
        redes.setNombreR(dtored.getNombreR());
        redes.setImg(dtored.getImg());
        redes.setLink(dtored.getLink());
        
        redServ.save(redes);
        
        return new ResponseEntity(new Mensaje("Red actualizada"), HttpStatus.OK);
    }
}
