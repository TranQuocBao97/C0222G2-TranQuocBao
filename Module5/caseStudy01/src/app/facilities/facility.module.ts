import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FacilityRoutingModule} from './facility-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgxPaginationModule} from 'ngx-pagination';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityAddComponent} from './facility-add/facility-add.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';


@NgModule({
  declarations: [
    FacilityListComponent,
    FacilityAddComponent,
    FacilityEditComponent
  ],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    NgxPaginationModule
  ]
})
export class FacilityModule { }
