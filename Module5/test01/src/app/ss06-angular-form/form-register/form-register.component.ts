import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Account} from './Account';
import {Country} from './Country';

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent implements OnInit {

  public accountList: Account[] = [];
  public countryList: Country[] = [];
  public mess = "";
  public tempPassword:  any = "";
  accountFrom : FormGroup;

  updateTempPassword($event: KeyboardEvent) {
    // @ts-ignore
    this.tempPassword = $event.target.value;
    console.log(this.tempPassword)
  }

  constructor() {
    this.accountFrom = new FormGroup({
      email: new FormControl("",[Validators.required,Validators.email]),
      passwordGroup: new FormGroup({
        password: new FormControl("",[Validators.required,Validators.minLength(6)]),
        confirmPassword : new FormControl("",[Validators.required]),
      }, this.validatePassword),
      country: new FormControl("",[Validators.required]),
      age: new FormControl("",[Validators.required,Validators.min(18)]),
      gender: new FormControl("",[Validators.required]),
      phone: new FormControl("",[Validators.required, Validators.pattern("^\\+84[0-9]{9,10}$")]),
    });


    this.accountList.push(
      {email: 'quocbao1217@gmail.com',gender: 'Male'},
      {email: 'haha@gmail.com',gender: 'FeMale'},
      {email: 'hehe@gmail.com',gender: 'FeMale'}
    )
    this.countryList.push(
      {id: 1,name: 'VietNam'},
      {id: 2,name: 'China'},
      {id: 3,name: 'Laos'}
    )
  }

  validatePassword(abstractControl: AbstractControl) {
    console.log(abstractControl)
    let temp = abstractControl.value;
    if(temp.password != temp.confirmPassword){
      return {'passNotMatch': true}
    }
    return null;
  }

  registerAccountToDataListWithReactive() {
    console.log(this.accountFrom);
    if(this.accountFrom.valid){
      console.log(this.accountFrom.value);
      this.accountList.push(this.accountFrom.value);
      this.mess = "Register Success";
    }else {
      this.mess = "Register Fail";
    }
  }


  ngOnInit(): void {
  }



}
