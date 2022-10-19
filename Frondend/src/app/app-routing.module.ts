import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditexperienciaComponent } from './components/experiencia/editexperiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditredesComponent } from './components/logo-ap/editredes.component';
import { NewRedesComponent } from './components/logo-ap/new-redes.component';
import { EditproyectoComponent } from './components/proyecto/editproyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { EditskillComponent } from './components/skill/editskill.component';
import { NewSkillComponent } from './components/skill/new-skill.component';

const routes: Routes = [
  { path:'', component: HomeComponent},
  { path:'login', component: LoginComponent},
  { path:'nuevaexp', component: NewExperienciaComponent},
  { path:'editexp/:id', component: EditexperienciaComponent},
  { path:'nuevaedu', component: NewEducacionComponent},
  { path:'editedu/:id', component: EditeducacionComponent},
  { path:'nuevohys', component: NewSkillComponent},
  { path:'edithys/:id', component: EditskillComponent},
  { path:'nuevopro', component: NewProyectoComponent},
  { path:'editpro/:id', component: EditproyectoComponent},
  { path:'nuevared', component: NewRedesComponent},
  { path:'editred/:id', component: EditredesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
