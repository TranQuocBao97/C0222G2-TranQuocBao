import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../models/CustomerType';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private API_CUSTOMER_TYPE = "http://localhost:3000/customerType";
  constructor(private httpClient: HttpClient) {

  }

  getAllCustomerType(): Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.API_CUSTOMER_TYPE)
  }
}
