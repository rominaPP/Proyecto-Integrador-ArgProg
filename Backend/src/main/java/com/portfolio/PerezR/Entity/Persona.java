package com.portfolio.PerezR.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    private String img;
    
    private String titulo;
    
    private String sobremi;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String titulo, String sobremi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.sobremi = sobremi;
    }

}
