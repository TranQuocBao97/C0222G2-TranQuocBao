import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';


let routes : Routes = [
  {
    path: 'add',
    component: CustomerAddComponent
  },
  {
    path: 'list',
    component: CustomerListComponent
  },
  {
    path: 'edit/:id',
    component: CustomerEditComponent
  },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class CustomerRoutingModule {

}
