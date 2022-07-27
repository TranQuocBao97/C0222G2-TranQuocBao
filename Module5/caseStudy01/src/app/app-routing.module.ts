import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ContractAddComponent} from './contract/contract-add/contract-add.component';
import {HomePageComponent} from './home-page/home-page.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';
import {CustomerAddComponent} from './customer/customer-add/customer-add.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {FacilityListComponent} from './facilities/facility-list/facility-list.component';
import {FacilityAddComponent} from './facilities/facility-add/facility-add.component';
import {FacilityEditComponent} from './facilities/facility-edit/facility-edit.component';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'contract-add', component: ContractAddComponent},
  {path: 'contract-list', component: ContractListComponent},
  {path: 'customer-add', component: CustomerAddComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
  {path: 'facility-list', component: FacilityListComponent},
  {path: 'facility-add', component: FacilityAddComponent},
  {path: 'facility-edit', component: FacilityEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
