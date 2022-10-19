export class Redes {
    id?: number;
    nombreR: string;
    img: string;
    link: string;

    constructor(nombreR: string, img: string, link: string){
        this.nombreR = nombreR;
        this.img = img;
        this.link = link;
    }
}
