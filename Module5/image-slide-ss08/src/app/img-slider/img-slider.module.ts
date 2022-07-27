import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ImgSlideComponent} from './img-slide/img-slide.component';
import {ImgSliderComponent} from './img-slider.component';
import {AppRoutingModule} from '../app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [ImgSliderComponent, ImgSlideComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ImgSliderComponent,
  ]
})
export class ImgSliderModule {
}
