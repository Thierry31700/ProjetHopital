import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceDp } from '../model/service-dp';

@Injectable({
  providedIn: 'root'
})
export class ServicedpService {

  private url: string='';
  constructor(private http: HttpClient) {}

  public allServicedp(): Observable<ServiceDp[]>{
      return this.http.get<ServiceDp[]>(this.url);
  
  
  }
  public findById(id: number): Observable<ServiceDp>{
  
    return this.http.get<ServiceDp>(`${this.url}/${id}`);
  }
  
  public delete(id: number): Observable<void> {
      return this.http.delete<void>(this.url + '/' + id);
    }
  
    public update(Servicedp: ServiceDp): Observable<ServiceDp> {
      return this.http.put<ServiceDp>(`${this.url}/${Servicedp.$id}`, Servicedp);
    }
  
    public insert(Servicedp: ServiceDp): Observable<ServiceDp> {
      const o = {
        libelle: Servicedp.$libelle,
       
  
      };
      return this.http.post<ServiceDp>(this.url, o);
    }
  }
