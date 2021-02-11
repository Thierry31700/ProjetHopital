import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  error: string = '';

  constructor(
    private activatedRoute :ActivatedRoute,
    private router: Router,
  ) 
  {
    this.activatedRoute.queryParams.subscribe((params) => {
      this.error = params.error;
    });
  }
  
  ngOnInit(): void {
  }

}
