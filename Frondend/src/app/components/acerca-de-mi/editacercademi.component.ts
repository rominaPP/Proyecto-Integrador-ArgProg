import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-editacercademi',
  templateUrl: './editacercademi.component.html',
  styleUrls: ['./editacercademi.component.css']
})
export class EditacercademiComponent implements OnInit {
  persona: Persona = null;
  
  constructor(private PerServ: PersonaService, private activatedRouter: ActivatedRoute, private router: Router, public imgServ: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.PerServ.detail(id).subscribe(data =>{
      this.persona = data;
    }, err => {
      alert("Error al modificar el perfil");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.persona.img = this.imgServ.url
    this.PerServ.update(id, this.persona).subscribe(data => {
      this.router.navigate([''])
      }, err =>{
        alert("Error al modificar el perfil");
        this.router.navigate(['']);
      }
    )
  }

  uploadImage($event:any){
    const id = this.activatedRouter.snapshot.params['id'];
    const name = 'perfil_' + id;
    this.imgServ.uploadImage($event, name)
  }

  volver():void{
    this.router.navigate(['']);
  }
}
