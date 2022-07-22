import { Component, OnInit } from '@angular/core';
import {AbstractControl, ValidationErrors, FormControl, FormGroup, Validators} from '@angular/forms';
import {Account} from '../form-register/Account';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {
  message: string = '';
  public accountAvailableList: Account[] = [];


  loginForm: FormGroup;

  constructor() {
    this.loginForm = new FormGroup({
      email: new FormControl('',[Validators.email]),
      password: new FormControl('',[Validators.minLength(6)]),
    })

    this.accountAvailableList.push(
      {email: 'quocbao1217@gmail.com',password: "123456"},
      {email: 'haha123@gmail.com',password: "123456"},
      {email: 'bobo456@gmail.com',password: "123456"},
    )
  }

  ngOnInit(): void {
  }

  checkEmail(email: AbstractControl){
    console.log('hi')
    return null;
  }

  checkLogin() {
    if(this.loginForm.valid) {
      this.message = "Success";
    }else {
      this.message = "Fail";
    }
  }
}
