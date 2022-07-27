import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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
      startDate: new FormControl("",[Validators.required]),
      endDate: new FormControl("",[Validators.required]),
      facility: new FormControl("",[Validators.required]),
      contractOtherServices: new FormControl("",[Validators.required])
    })
  }
}

export class ContractAddAppComponent {
}
