import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../model/login';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login: Login = new Login();
  erreur: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  public send() {
    this.loginService.auth(this.login).subscribe(
      (result) => {
        sessionStorage.setItem(
          'tokenId',
          btoa(`${this.login.mail}:${this.login.password}`)
        );
        console.log(sessionStorage.getItem('tokenId'));
        sessionStorage.setItem('login', this.login.mail);
        this.router.navigate(['/home']);
      },
      (error) => {
        this.erreur = true;
      }
    );
  }
}
