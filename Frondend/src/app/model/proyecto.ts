export class Proyecto {
    id?: number;
    nombrePro: string;
    descripPro: string;
    inicioPro: string;

    constructor(nombrePro: string, descripPro: string, inicioPro: string){
        this.nombrePro = nombrePro;
        this.descripPro = descripPro;
        this.inicioPro = inicioPro;
    }
}
