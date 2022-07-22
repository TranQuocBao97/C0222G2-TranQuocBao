import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Test01Component } from './test01/test01.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PetComponent } from './pet/pet.component';
import { ProductComponent } from './product/product.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { AngularColorPickerAppComponent } from './angular-color-picker-app/angular-color-picker-app.component';
import { ArticleComponent } from './ss04/article/article.component';
import { LikeComponent } from './like/like.component';
import { NavbarComponent } from './ss04/navbar/navbar.component';
import { FooterComponent } from './ss04/footer/footer.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { TodoComponent } from './todo/todo.component';
import { FormRegisterComponent } from './ss06-angular-form/form-register/form-register.component';
import { FormLoginComponent } from './ss06-angular-form/form-login/form-login.component';

@NgModule({
  declarations: [
    AppComponent,
    Test01Component,
    FontSizeEditorComponent,
    PetComponent,
    ProductComponent,
    CalculatorComponent,
    AngularColorPickerAppComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    NameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    TodoComponent,
    FormRegisterComponent,
    FormLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
