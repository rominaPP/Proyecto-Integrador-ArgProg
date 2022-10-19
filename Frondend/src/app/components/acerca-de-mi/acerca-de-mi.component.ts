import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de-mi',
  templateUrl: './acerca-de-mi.component.html',
  styleUrls: ['./acerca-de-mi.component.css']
})
export class AcercaDeMiComponent implements OnInit {
  persona: Persona = null;
    
  constructor(public PerServ: PersonaService, private tokenService: TokenService) { }
  isLogged = false;
  
  ngOnInit(): void {
    this.cargarPersona();
    if(this.tokenService.getToken()){
      this.isLogged = true;
      } else{
        this.isLogged = false;
      }
  }

  cargarPersona(): void{
    this.PerServ.detail(1).subscribe(
      data => {this.persona = data;}
    )
  }

}
