import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-editskill',
  templateUrl: './editskill.component.html',
  styleUrls: ['./editskill.component.css']
})
export class EditskillComponent implements OnInit {
  hys: Skill = null;

  constructor(private hysServ: SkillService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hysServ.detail(id).subscribe(data =>{
      this.hys = data;
    }, err => {
      alert("Error al modificar Hard & Soft Skills");
      this.router.navigate(['']);
    }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hysServ.update(id, this.hys).subscribe(data => {this.router.navigate([''])
    }, err =>{
      alert("Error al modificar Hard & Soft Skills");
      this.router.navigate(['']);
    }
    )
  }
  volver():void{
    this.router.navigate(['']);
  }
}
