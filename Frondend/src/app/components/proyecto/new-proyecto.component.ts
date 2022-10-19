import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  nombrePro: string = '';
  descripPro: string = ''; 
  inicioPro: string = '';
  
  constructor(private ProServ: ProyectoService, private router: Router, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    
    const Pro = new Proyecto(this.nombrePro, this.descripPro, this.inicioPro)
      
      this.ProServ.save(Pro).subscribe(data => {
      alert("Proyecto añadido");
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
