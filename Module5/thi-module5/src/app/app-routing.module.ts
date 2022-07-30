import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PackListComponent} from './pack/pack-list/pack-list.component';
import {PackAddComponent} from './pack/pack-add/pack-add.component';
import {PackEditComponent} from './pack/pack-edit/pack-edit.component';



const routes: Routes = [
  {path: '', component: PackListComponent},
  {path: 'pack/add', component: PackAddComponent},
  {path: 'pack/edit/:id', component: PackEditComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
