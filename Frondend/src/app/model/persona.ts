export class Persona{
    id?:number;
    nombre:string;
    apellido:string;
    img:string;
    titulo:string;
    sobremi:string;    

    constructor(nombre:string, apellido:string, img:string, titulo:string, sobremi:string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.sobremi = sobremi;
    }
}