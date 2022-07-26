import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Contract} from '../models/Contract';
import { Observable } from 'rxjs';
import {Customer} from '../models/Customer';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private API_CONTRACT = "http://localhost:8080/api/contract/";

  constructor(private httpClient: HttpClient) { }

  getAllContracts(): Observable<Contract[]> {
    return this.httpClient.get<Customer[]>(this.API_CONTRACT+'list')
  }
}
