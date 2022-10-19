import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {
  nombreEdu: string = '';
  descripEdu: string = ''; 
  inicioEdu: string = '';
  finEdu: string = '';
  constructor(private EduServ: EducacionService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const edu = new Educacion(this.nombreEdu, this.descripEdu, this.inicioEdu, this.finEdu);
    this.EduServ.save(edu).subscribe(data => {
      alert("Educación añadida");
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
