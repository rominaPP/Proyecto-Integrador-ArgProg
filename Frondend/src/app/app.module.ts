import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideStorage,getStorage } from '@angular/fire/storage';
import { HeaderComponent } from './components/header/header.component';
import { LogoAPComponent } from './components/logo-ap/logo-ap.component';
import { EditredesComponent } from './components/logo-ap/editredes.component';
import { NewRedesComponent } from './components/logo-ap/new-redes.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaDeMiComponent } from './components/acerca-de-mi/acerca-de-mi.component';
import { EditacercademiComponent } from './components/acerca-de-mi/editacercademi.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EditexperienciaComponent } from './components/experiencia/editexperiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoAPComponent,
    EditredesComponent,
    NewRedesComponent,
    BannerComponent,
    AcercaDeMiComponent,
    EditacercademiComponent,
    ExperienciaComponent,
    EditexperienciaComponent,
    NewExperienciaComponent,
    EducacionComponent,
    EditeducacionComponent,
    NewEducacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage()),
    NgCircleProgressModule.forRoot({})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
