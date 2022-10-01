package com.portfolio.PerezR.Dto;


public class PersonaDto {
    private String nombre;
    
    private String apellido;
    
    private String img;
    
    private String titulo;
    
    private String sobremi;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String img, String titulo, String sobremi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.sobremi = sobremi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSobremi() {
        return sobremi;
    }

    public void setSobremi(String sobremi) {
        this.sobremi = sobremi;
    }
    
}
