import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employe } from 'src/app/model/employe';
import { EmployeService } from 'src/app/service/employe.service';

@Component({
  selector: 'app-employe-edit',
  templateUrl: './employe-edit.component.html',
  styleUrls: ['./employe-edit.component.css']
})
export class EmployeEditComponent implements OnInit {
employe:Employe = new Employe();

constructor(
  private activatedRoute: ActivatedRoute,
    private router: Router,
    private employeService: EmployeService,
) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.employeService.findById(params.id).subscribe((data) => {
          this.employe = data;
        });
      }
    });
  }
  public save() {
    if (this.employe.id) {
      this.employeService.update(this.employe).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.employeService.insert(this.employe).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }
  private goList(info: Object) {
    this.router.navigate(['/employe'], { queryParams: info });
   }



  }
