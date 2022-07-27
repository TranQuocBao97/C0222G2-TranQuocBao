import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-facility-add',
  templateUrl: './facility-add.component.html',
  styleUrls: ['./facility-add.component.css']
})
export class FacilityAddComponent implements OnInit {
  facilityForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  getFacilityForm(){
    this.facilityForm = new FormGroup({
      name: new FormControl("",[Validators.required, Validators.pattern("^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$")]),
      area: new FormControl("",[Validators.required]),
      cost: new FormControl("",[Validators.required,Validators.min(100000)]),
      facilityType: new FormControl("",[Validators.required]),
      rentType: new FormControl("",[Validators.required])
    })
  }
}
