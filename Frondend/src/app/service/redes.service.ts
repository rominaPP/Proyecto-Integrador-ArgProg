import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Redes } from '../model/redes';

@Injectable({
  providedIn: 'root'
})
export class RedesService {
  rURL ='https://backendrperez.herokuapp.com/redes/';

  constructor(private httpClient: HttpClient) { } 

  public lista(): Observable<Redes[]>{
    return this.httpClient.get<Redes[]>(this.rURL + 'lista');
  }

  public detail(id: number): Observable<Redes>{
    return this.httpClient.get<Redes>(this.rURL + `detail/${id}`);
  }

  public save(redes: Redes): Observable<any>{
    return this.httpClient.post<any>(this.rURL + `create`, redes);
  }

  public update(id: number, redes: Redes): Observable<any>{
    return this.httpClient.put<any>(this.rURL + `update/${id}`, redes);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.rURL + `delete/${id}`);
  }
}
