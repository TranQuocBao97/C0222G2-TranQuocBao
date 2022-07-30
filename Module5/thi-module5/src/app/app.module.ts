import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MainListComponent } from './main-object/main-list/main-list.component';
import { MainAddComponent } from './main-object/main-add/main-add.component';
import { MainEditComponent } from './main-object/main-edit/main-edit.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {NgxPaginationModule} from 'ngx-pagination';
import { PackListComponent } from './pack/pack-list/pack-list.component';
import { PackAddComponent } from './pack/pack-add/pack-add.component';
import { PackEditComponent } from './pack/pack-edit/pack-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainListComponent,
    MainAddComponent,
    MainEditComponent,
    PackListComponent,
    PackAddComponent,
    PackEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
