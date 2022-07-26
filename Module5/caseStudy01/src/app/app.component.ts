import { Component } from '@angular/core';
import {Subscription} from 'rxjs';
import {Employee} from './models/Employee';
import {EmployeeService} from './services/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'caseStudy01';

  private subscription: Subscription;
  public employees: Employee[] = [];


  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.getAllEmployee();
  }

  getAllEmployee() {
    this.subscription = this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
    },error => {
      console.log(error);
    })
  }
}
