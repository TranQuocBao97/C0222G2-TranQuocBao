import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Customer} from '../../models/Customer';
import {CustomerService} from '../../services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  private subscription: Subscription;
  public customerList: Customer[] = [];

  constructor(private customerService: CustomerService) {

  }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.subscription = this.customerService.getAllCustomer().subscribe(data =>{
      this.customerList = data;
      console.log(this.customerList);
    }, error => {
      console.log(error);
    })
  }
}
