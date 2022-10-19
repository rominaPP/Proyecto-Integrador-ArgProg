import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-editproyecto',
  templateUrl: './editproyecto.component.html',
  styleUrls: ['./editproyecto.component.css']
})
export class EditproyectoComponent implements OnInit {
  pro: Proyecto = null;
  
  constructor(private ProServ: ProyectoService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.ProServ.detail(id).subscribe(data =>{
      this.pro = data;
    }, err => {
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.ProServ.update(id, this.pro).subscribe(data => {this.router.navigate([''])
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
