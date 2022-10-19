export class Experiencia {
    id?: number;
    nombreExp: string;
    descripExp: string;
    inicioExp: string;
    finExp: string;

    constructor(nombreExp: string, descripExp: string, inicioExp: string, finExp: string) {
        this.nombreExp = nombreExp;
        this.descripExp = descripExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
    }
}
