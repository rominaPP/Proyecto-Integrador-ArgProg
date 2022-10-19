import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skill } from '../model/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  SyHURL ='https://backendrperez.herokuapp.com/hys/';

  constructor(private httpClient: HttpClient) { } 

  public lista(): Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.SyHURL + 'lista');
  }

  public detail(id: number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.SyHURL + `detail/${id}`);
  }

  public save(skill: Skill): Observable<any>{
    return this.httpClient.post<any>(this.SyHURL + `create`, skill);
  }

  public update(id: number, skill: Skill): Observable<any>{
    return this.httpClient.put<any>(this.SyHURL + `update/${id}`, skill);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.SyHURL + `delete/${id}`);
  }
}
