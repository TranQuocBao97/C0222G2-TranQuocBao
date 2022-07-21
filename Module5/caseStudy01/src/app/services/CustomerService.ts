import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../models/Customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly API_URL = 'http://localhost:8080/api/customer/list';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL)
  }
}
