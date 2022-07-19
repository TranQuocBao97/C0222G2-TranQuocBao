import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})

export class CalculatorComponent implements OnInit {
  number1 = 0 ;
  number2 = 0 ;
  result = 0 ;
  constructor() { }

  ngOnInit(): void {
  }
  plus() {
    this.result = this.number1 + this.number2;
  }
  sub() {
    this.result = this.number1 - this.number2;
  }
  mul() {
    this.result = this.number1 * this.number2;
  }
  div() {
    this.result = this.number1 / this.number2;
  }
}
