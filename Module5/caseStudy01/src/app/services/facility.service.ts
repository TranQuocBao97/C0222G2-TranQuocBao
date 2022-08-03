import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Facility} from '../models/Facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  private readonly API_URL = 'http://localhost:8080/api/facility/list'

  constructor(private httpClient: HttpClient) {
  }

  getAllFacilities(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(this.API_URL);
  }

  getAllFacilitiesWithPage(pageCurrent: number): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(this.API_URL + `?page=${pageCurrent}`);
  }

  addFacility(facility: Facility): Observable<Facility>{
    return this.httpClient.post<Facility>("http://localhost:8080/api/facility/", facility);
  }
}
