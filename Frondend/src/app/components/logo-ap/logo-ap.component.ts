import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Redes } from 'src/app/model/redes';
import { RedesService } from 'src/app/service/redes.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-logo-ap',
  templateUrl: './logo-ap.component.html',
  styleUrls: ['./logo-ap.component.css']
})
export class LogoAPComponent implements OnInit {
  isLogged = false;
  red : Redes[] = []
  

  constructor(private router:Router, private tokenService: TokenService, private activatedRouter: ActivatedRoute, private redServ: RedesService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else
    this.isLogged = false;
    
    this.cargarRed();
    if(this.tokenService.getToken()){
    this.isLogged = true;
    } else{
      this.isLogged = false;
    }
  }

  cargarRed(): void{
    this.redServ.lista().subscribe(
      data => {this.red = data;}
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.redServ.delete(id).subscribe(
        data => {
          this.cargarRed();
      }, err =>{
      alert("No se pudo eliminar la red")
      })
    }
  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }
  login(){
    this.router.navigate(['/login'])
  }
 
}
