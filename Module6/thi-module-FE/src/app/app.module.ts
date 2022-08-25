import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ToastrModule} from 'ngx-toastr';
import { FooterComponent } from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import { HomePageComponent } from './home-page/home-page.component';
import { Error404PageComponent } from './error404-page/error404-page.component';
import {ProductModule} from './product/product.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    Error404PageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-left',
        preventDuplicates: true,
      }
    ),
    ProductModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
