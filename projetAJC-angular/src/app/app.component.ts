import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projetAJC-angular';
  _user :string= '';

  constructor(private router: Router) {}

  public logout(){
    sessionStorage.removeItem('tokenId');
    sessionStorage.removeItem('login');
    this._user='';
    this.router.navigate(['/home']);
  }
  public get user(){
    return sessionStorage.getItem('login');
  }
}
