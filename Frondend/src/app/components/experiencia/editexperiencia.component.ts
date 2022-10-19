import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ExperienciaService } from 'src/app/service/experiencia.service';

@Component({
  selector: 'app-editexperiencia',
  templateUrl: './editexperiencia.component.html',
  styleUrls: ['./editexperiencia.component.css']
})
export class EditexperienciaComponent implements OnInit {
  expe: Experiencia = null;

  constructor(private ExpServ: ExperienciaService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.ExpServ.detail(id).subscribe(data =>{
      this.expe = data;
    }, err => {
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.ExpServ.update(id, this.expe).subscribe(data => {this.router.navigate([''])
    }, err =>{
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    }
    )
  }
  volver():void{
    this.router.navigate(['']);
  }
}
