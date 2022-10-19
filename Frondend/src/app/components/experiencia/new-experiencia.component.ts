import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombreExp: string = '';
  descripExp: string = ''; 
  inicioExp: string = '';
  finExp: string = '';
  constructor(private ExpServ: ExperienciaService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const expe = new Experiencia(this.nombreExp, this.descripExp, this.inicioExp, this.finExp);
    this.ExpServ.save(expe).subscribe(data => {
      alert("Experiencia añadida");
      this.router.navigate(['']);
      }, err =>{
      alert("Fallo");
      this.router.navigate(['']);
      }
    )
  }

  volver():void{
    this.router.navigate(['']);
  }
  
}
