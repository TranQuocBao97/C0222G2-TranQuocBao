import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {CustomerTypeService} from '../../services/customer-type.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../models/CustomerType';
import {Router} from '@angular/router';
import {MessService} from '../../services/mess.service';
import * as moment from 'moment';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  customerTypeList: CustomerType[] = [];
  customerForm: FormGroup;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private messService: MessService) {
    this.customerTypeService.getAllCustomerType().subscribe(data => {
      this.customerTypeList = data;
    }, error => {
      console.log(error);
    }, () => {

    })
  }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl("",[Validators.required, Validators.pattern("^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$")]),
      dateOfBirth: new FormControl("",[Validators.required, this.validateDate]),
      idCard: new FormControl("",[Validators.required, Validators.pattern("^[0-9]{9}$")]),
      email: new FormControl("",[Validators.required, Validators.email]),
      gender: new FormControl("",[Validators.required]),
      customerType: new FormControl("",[Validators.required])
    })
  }

  validateDate(AC: AbstractControl) {
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return { 'dateValidator': true };
    }
    return null;
  }


  addNewCustomer() {
    if(this.customerForm.valid){
      this.customerService.addCustomer(this.customerForm.value).subscribe(data => {

      }, error => {

      }, () => {
        this.router.navigate(['customer-list'])
        this.messService.showSuccess('Thêm mới thành công','Thêm mới')
      })
    }else {
      this.customerForm.markAllAsTouched();
      this.messService.showError('Thêm mới thất bại', 'Lỗi Thêm mới')
    }

  }
}
