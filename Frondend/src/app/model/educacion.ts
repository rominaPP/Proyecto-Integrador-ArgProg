export class Educacion {
    id?: number;
    nombreEdu: string;
    descripEdu: string;
    inicioEdu: string;
    finEdu: string;

    constructor(nombreEdu: string, descripEdu: string, inicioEdu: string, finEdu: string){
        this.nombreEdu = nombreEdu;
        this.descripEdu = descripEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
    }
}
