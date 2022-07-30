import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pack} from '../models/Pack';

@Injectable({
  providedIn: 'root'
})
export class PackService {
  private readonly API_URL = 'http://localhost:8080/api/pack/';
  constructor(private httpClient: HttpClient) { }

  getAllPack(): Observable<Pack[]>{
    return this.httpClient.get<Pack[]>(this.API_URL);
  }
  getAllPackWithPage(pageNumber: number): Observable<Pack[]>{
    return this.httpClient.get<Pack[]>(this.API_URL + `?page=${pageNumber}`);
  }

  deletePackById(id: number): Observable<Pack>{
    return this.httpClient.delete<Pack>(this.API_URL+ id);
  }

  addPack(pack: Pack): Observable<Pack>{
    return this.httpClient.post<Pack>(this.API_URL, pack);
  }

  search(nameProduct: string, dateOver: string): Observable<Pack[]>{
    return this.httpClient.get<Pack[]>("http://localhost:3000/pack?product.name_like="+nameProduct+"&dateOver_like="+dateOver);
  }


}
