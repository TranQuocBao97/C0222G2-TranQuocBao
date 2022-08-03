import { Component, OnInit } from '@angular/core';
import {Subscription} from 'rxjs';
import {Facility} from '../../models/Facility';
import {FacilityService} from '../../services/facility.service';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  private subscriptions: Subscription;
  public facilityList: Facility[] = [];
  checkFirstPage: boolean;
  checkNextPage: boolean;
  numberPage: number = 0;

  constructor(private facilityService: FacilityService) { }

  ngOnInit(): void {
    this.getFacilityByPageNumber(this.numberPage);
  }

  getFacilityByPageNumber(numberPage) {
    this.subscriptions = this.facilityService.getAllFacilitiesWithPage(numberPage).subscribe( data => {
      // @ts-ignore
      this.facilityList = data.content;
      // console.log(JSON.stringify(this.facilityList));
      // @ts-ignore
      this.checkFirstPage = data.first;
      // @ts-ignore
      this.checkNextPage = data.last;
    }, error => {
      console.log(error);
    })
  }

  nextPage() {
    this.numberPage+=1;
    this.getFacilityByPageNumber(this.numberPage);
  }

  previousPage() {
    this.numberPage-=1;
    this.getFacilityByPageNumber(this.numberPage);
  }
}
