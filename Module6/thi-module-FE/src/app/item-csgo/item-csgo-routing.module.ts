import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListItemComponent} from './list-item/list-item.component';


const routes: Routes = [
  {
    path: 'item-csgo',
    component : ListItemComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ItemCsgoRoutingModule { }
