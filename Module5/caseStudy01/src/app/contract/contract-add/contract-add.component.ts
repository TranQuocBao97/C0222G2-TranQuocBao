import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import * as moment from 'moment';

@Component({
  selector: 'app-contract-add',
  templateUrl: './contract-add.component.html',
  styleUrls: ['./contract-add.component.css']
})
export class ContractAddComponent implements OnInit {
  contractForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  getContractForm(){
    this.contractForm = new FormGroup({
      startDate: new FormControl("",[Validators.required, this.validateDate]),
      endDate: new FormControl("",[Validators.required, this.validateDate]),
      facility: new FormControl("",[Validators.required]),
      contractOtherServices: new FormControl("",[Validators.required])
    })
  }

  validateDate(AC: AbstractControl) {
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return { 'dateValidator': true };
    }
    return null;
  }

}

export class ContractAddAppComponent {
}
