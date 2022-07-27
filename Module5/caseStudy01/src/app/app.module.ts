import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {FacilityListComponent} from './facilities/facility-list/facility-list.component';
import {FacilityAddComponent} from './facilities/facility-add/facility-add.component';
import {FacilityEditComponent} from './facilities/facility-edit/facility-edit.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerAddComponent} from './customer/customer-add/customer-add.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';
import {ContractAddComponent} from './contract/contract-add/contract-add.component';
import {HomePageComponent} from './home-page/home-page.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FacilityListComponent,
    FacilityAddComponent,
    FacilityEditComponent,
    CustomerListComponent,
    CustomerAddComponent,
    CustomerEditComponent,
    ContractListComponent,
    ContractAddComponent,
    HomePageComponent
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
export class AppModule {
}
