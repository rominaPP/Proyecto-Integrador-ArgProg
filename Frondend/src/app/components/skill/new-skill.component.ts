import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
  nombreHyS: string = '';
  porcentaje: number;

  constructor(private HySServ: SkillService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const hys = new Skill(this.nombreHyS, this.porcentaje);
    this.HySServ.save(hys).subscribe(data => {
      alert("Hard & Soft Skills añadida");
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
