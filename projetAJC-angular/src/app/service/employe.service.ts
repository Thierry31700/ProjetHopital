import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employe } from '../model/employe';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {
  private url: string='';

private httpHeaders: HttpHeaders;


  constructor( private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({


    
    });
   }
   public allEmploye(): Observable<Employe[]>{
     return this.http.get<Employe[]>(this.url,{headers: this.httpHeaders});
   }
   public delete(id: number): Observable<void>{
     return this.http.delete<void>(this.url + '/' +id);
   }
   public findById(id:number): Observable<Employe>{
     return this.http.get<Employe>(this.url + '/'+id);
   }
   public update(employe: Employe): Observable<Employe> {
    return this.http.put<Employe>(`${this.url}/${employe.id}`, employe);
  }
  public insert(employe: Employe): Observable<Employe> {
    const o = {
      nom: employe.nom,
      prenom: employe.prenom,
      manager: employe.manager,
      

    };
    return this.http.post<Employe>(this.url, o);
  }
}
