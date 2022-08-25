import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly API_URL = 'http://localhost:8080/product/';

  constructor(private httpClient: HttpClient) { }

  getAllProductWithPage(pageNumber: number): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.API_URL + "page" + `?page=${pageNumber}`);
  }


  getAllProductWithList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.API_URL + "list");
  }

  deleteProductById(id: number): Observable<Product>{
    return this.httpClient.delete<Product>(this.API_URL+ id);
  }

  addProduct(product: Product):Observable<Product>{
    return this.httpClient.post<Product>(this.API_URL, product);
  }
}
