import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projetAJC-angular';
  user :string= sessionStorage.getItem('mail');

  constructor(private router: Router) {}

  public logout(){
    sessionStorage.removeItem('tokenId');
    sessionStorage.removeItem('mail');
    this.user='';
    this.router.navigate(['/home']);
  }
  
}
