import {Component, OnInit} from '@angular/core';
import {Customer} from '../../models/Customer';
import {CustomerService} from '../../services/customer.service';
import {Router} from '@angular/router';
import {MessService} from '../../services/mess.service';
import {FormControl, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customerList: Customer[] = [];
  name: string;
  email: string;
  idDelete: number;
  page: number = 1;
  searchForm: FormGroup;

  constructor(private customerService: CustomerService,
              private router: Router,
              private messService: MessService) {

  }

  ngOnInit(): void {
    this.getAllCustomer();
    this.formSearch();
  }


  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customerList = data;
      console.log(this.customerList);
    }, error => {
      console.log(error);
    });
  }

  showDelete(customer: Customer) {
    this.idDelete = customer.id;
    this.name = customer.name;
    this.email = customer.email;
  }

  deleteCustomer() {
    this.customerService.deleteCustomerById(this.idDelete).subscribe(data => {

    }, error => {

    }, () => {
      this.ngOnInit();
      this.messService.showSuccess('Xóa thành công', 'Xóa');
    });
  }

  formSearch(){
    this.searchForm = new FormGroup({
      nameSearch: new FormControl(""),
      emailSearch: new FormControl("")
    });
  }

  getFormSearch() {
    this.customerService.getCustomerListBySearch(this.searchForm.value.nameSearch,this.searchForm.value.emailSearch).subscribe(data => {
      this.customerList = data;
      console.log(data);
    }, error => {

    }, () => {

    })
  }
}
