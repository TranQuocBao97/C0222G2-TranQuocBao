import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerService} from '../../services/customer.service';
import {CustomerTypeService} from '../../services/customer-type.service';
import {CustomerType} from '../../models/CustomerType';
import {Customer} from '../../models/Customer';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {MessService} from '../../services/mess.service';
import * as moment from 'moment';


@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id: any;
  customerTypeList: CustomerType[] = [];
  customerType: CustomerType;
  customer: Customer;
  customerForm: FormGroup;


  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private messService: MessService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    }, error => {
    }, () => {
    });
  }


  getCustomerTypeList() {
    this.customerTypeService.getAllCustomerType().subscribe(data => {
      this.customerTypeList = data;
    }, error => {
    }, () => {
    });
  }

  getCustomerById() {
    this.customerService.findCustomerById(this.id).subscribe(data => {
      this.customer = data;
      this.customerType = this.customer.customerType;
    }, error => {

    }, () => {
      this.getCustomerTypeList();
      this.getFormEditCustomer();
    });
  }

  getFormEditCustomer(){
    this.customerForm = new FormGroup({
      id: new FormControl(this.customer.id),
      name: new FormControl(this.customer.name,[Validators.required, Validators.pattern("^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$")]),
      dateOfBirth: new FormControl(this.customer.dateOfBirth,[Validators.required, this.validateDate]),
      idCard: new FormControl(this.customer.idCard,[Validators.required, Validators.pattern("^[0-9]{9}$")]),
      email: new FormControl(this.customer.email,[Validators.required, Validators.email]),
      gender: new FormGroup(this.customer.gender,[Validators.required]),
      customerType: new FormControl(this.customer.customerType,[Validators.required]),
    });
  }

  validateDate(AC: AbstractControl) {
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return { 'dateValidator': true };
    }
    return null;
  }


  ngOnInit(): void {
    this.getCustomerById();
  }




  EditCustomer(id: number) {
    if(this.customerForm.valid) {
      this.customer = this.customerForm.value;
      this.customerService.updateCustomer(id, this.customer).subscribe(data => {

      }, error => {

      }, () => {
        this.router.navigate(['customer-list'])
        this.messService.showSuccess('Update Thành công', 'Edit');
      });
    }else {
      this.messService.showError('Update thất bại', 'Edit');
    }

  }

  defaultSelectCustomerType(c1: CustomerType, c2: CustomerType) {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }



}
