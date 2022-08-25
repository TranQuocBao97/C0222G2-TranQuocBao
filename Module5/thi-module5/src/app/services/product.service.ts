import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly API_URL = 'http://localhost:8080/api/product/';

  constructor(private httpClient: HttpClient) {
  }

  getAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API_URL);
  }


}
