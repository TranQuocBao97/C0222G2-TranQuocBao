import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../models/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private readonly API_URL = 'http://localhost:8080/api/employee/list';



  constructor(private httpClient: HttpClient) {

  }

  getAllEmployee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.API_URL);
  }
}
