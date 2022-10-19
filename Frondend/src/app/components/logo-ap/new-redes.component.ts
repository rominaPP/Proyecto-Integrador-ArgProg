import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Redes } from 'src/app/model/redes';
import { RedesService } from 'src/app/service/redes.service';

@Component({
  selector: 'app-new-redes',
  templateUrl: './new-redes.component.html',
  styleUrls: ['./new-redes.component.css']
})
export class NewRedesComponent implements OnInit {
  nombreR: string = "";
  img: string= "";
  link: string = "";

  constructor(private redServ: RedesService, private router: Router, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    
    const Red = new Redes(this.nombreR, this.img, this.link)
      
      this.redServ.save(Red).subscribe(data => {
      alert("Red añadida");
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
