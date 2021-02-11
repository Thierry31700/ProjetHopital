import { Component, OnInit } from '@angular/core';
import { Employe } from 'src/app/model/employe';
import { EmployeService } from 'src/app/service/employe.service';

@Component({
  selector: 'app-employe-list',
  templateUrl: './employe-list.component.html',
  styleUrls: ['./employe-list.component.css']
})
export class EmployeListComponent implements OnInit {
employes: Employe[]= [];
  constructor(private employeService: EmployeService) { }

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.employeService.findAll().subscribe((data) => {
      this.employes = data;
    });
  }

  public delete(id: number) {
    this.employeService.delete(id).subscribe((result) => {
      this.init();
    });
  }
}
