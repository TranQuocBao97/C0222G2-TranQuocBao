import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../models/Customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly API_URL = 'http://localhost:3000/customer/';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL);
  }

  findCustomerById(id: number): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL + id);
  }

  addCustomer(customer: Customer): Observable<Customer>{
    return this.httpClient.post<Customer>(this.API_URL , customer);
  }

  deleteCustomerById(id: number): Observable<Customer>{
    return this.httpClient.delete<Customer>(this.API_URL + id);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer>{
    return this.httpClient.put<Customer>(this.API_URL + id, customer);
  }

  getCustomerListBySearch(nameSearch: string, emailSearch: string): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>("http://localhost:3000/customer?name_like="+nameSearch+"&email_like="+ emailSearch);
  }

}
