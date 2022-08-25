import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {
  private readonly API_URL = 'http://localhost:8080/product-type/';

  constructor(private httpClient: HttpClient) { }

  getAllProductType(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.API_URL);
  }
}
