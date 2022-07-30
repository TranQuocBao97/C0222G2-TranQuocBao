import { Injectable } from '@angular/core';
import {MainObject} from '../models/MainObject';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  private readonly API_URL = 'http://localhost:3000/customer/';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<MainObject[]>{
    return this.httpClient.get<MainObject[]>(this.API_URL);
  }

  findCustomerById(id: number): Observable<MainObject>{
    return this.httpClient.get<MainObject>(this.API_URL + id);
  }

  addCustomer(customer: MainObject): Observable<MainObject>{
    return this.httpClient.post<MainObject>(this.API_URL , customer);
  }

  deleteCustomerById(id: number): Observable<MainObject>{
    return this.httpClient.delete<MainObject>(this.API_URL + id);
  }

  updateCustomer(id: number, customer: MainObject): Observable<MainObject>{
    return this.httpClient.put<MainObject>(this.API_URL + id, customer);
  }

  getCustomerListBySearch(nameSearch: string, emailSearch: string): Observable<MainObject[]>{
    return this.httpClient.get<MainObject[]>("http://localhost:3000/customer?name_like="+nameSearch+"&email_like="+ emailSearch);
  }
}
