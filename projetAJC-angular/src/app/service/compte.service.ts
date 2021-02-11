import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  private url: string='';
  constructor(private http: HttpClient) {}

  public allCompte(): Observable<Compte[]>{
      return this.http.get<Compte[]>(this.url);
  
  
  }
  public findById(id: number): Observable<Compte>{
  
    return this.http.get<Compte>(`${this.url}/${id}`);
  }
  
  public delete(id: number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id);
    }
  
    public update(Compte: Compte): Observable<Compte> {
      return this.http.put<Compte>(`${this.url}/${Compte.$id}`, Compte);
    }
  
    public insert(Compte: Compte): Observable<Compte> {
      const o = {
        mail: Compte.mail,
        password: Compte.password,
  
      };
      return this.http.post<Compte>(this.url, o);
    }
  }
