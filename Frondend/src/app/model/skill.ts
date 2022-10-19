export class Skill {
    id?: number;
    nombreHyS: string;
    porcentaje: number;

    constructor(nombreHyS: string, porcentaje: number){
        this.nombreHyS = nombreHyS;
        this.porcentaje = porcentaje;
    }
}
