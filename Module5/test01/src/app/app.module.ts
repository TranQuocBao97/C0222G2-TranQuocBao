import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Test01Component } from './test01/test01.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import {FormsModule} from '@angular/forms';
import { PetComponent } from './pet/pet.component';
import { ProductComponent } from './product/product.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { AngularColorPickerAppComponent } from './angular-color-picker-app/angular-color-picker-app.component';
import { ArticleComponent } from './article/article.component';
import { LikeComponent } from './like/like.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';

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
    RatingBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
