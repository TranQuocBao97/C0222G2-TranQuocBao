import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityAddComponent} from './facility-add/facility-add.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';


let routes : Routes = [
  {path: 'list', component: FacilityListComponent},
  {path: 'add', component: FacilityAddComponent},
  {path: 'edit/:id', component: FacilityEditComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
