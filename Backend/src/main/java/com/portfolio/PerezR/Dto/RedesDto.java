package com.portfolio.PerezR.Dto;


public class RedesDto {
     
    private String nombreR;
    
    private String img;
    
    private String link; 
    
    //Constructor

    public RedesDto() {
    }

    public RedesDto(String nombreR, String img, String link) {
        this.nombreR = nombreR;
        this.img = img;
        this.link = link;
    }
    
    //Getter and Setter

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
