import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ContractRoutingModule} from './contract-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToastrModule} from 'ngx-toastr';
import {NgxPaginationModule} from 'ngx-pagination';
import {ContractListComponent} from './contract-list/contract-list.component';
import {ContractAddComponent} from './contract-add/contract-add.component';


@NgModule({
  declarations: [
    ContractListComponent,
    ContractAddComponent
  ],
  imports: [
    CommonModule,
    ContractRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgxPaginationModule
  ]
})
export class ContractModule {
}
