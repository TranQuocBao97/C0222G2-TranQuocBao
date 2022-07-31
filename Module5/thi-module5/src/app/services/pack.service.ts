import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
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

  getPackById(id: number): Observable<Pack>{
    return this.httpClient.get<Pack>(this.API_URL + "getOne/"+ id);
  }

  deletePackById(id: number): Observable<Pack>{
    return this.httpClient.delete<Pack>(this.API_URL+ id);
  }

  addPack(pack: Pack): Observable<Pack>{
    return this.httpClient.post<Pack>(this.API_URL, pack);
  }

  editPack(pack: Pack): Observable<Pack>{
    return this.httpClient.put<Pack>(this.API_URL, pack);
  }

  search(nameProduct: string): Observable<Pack[]>{
    if(nameProduct===null){
      nameProduct = "";
    }
    return this.httpClient.get<Pack[]>(this.API_URL + "search/?name=" + nameProduct);
  }



}
