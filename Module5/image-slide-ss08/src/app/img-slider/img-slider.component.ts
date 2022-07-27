import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-img-slider',
  templateUrl: './img-slider.component.html',
  styleUrls: ['./img-slider.component.css']
})
export class ImgSliderComponent implements OnInit {
  border = false;
  color = false;
  marginR = 0;
  constructor() { }

  ngOnInit(): void {
  }

  right() {
    this.marginR = this.marginR + 10;
  }

  left() {
    this.marginR = this.marginR - 10;
  }
}
