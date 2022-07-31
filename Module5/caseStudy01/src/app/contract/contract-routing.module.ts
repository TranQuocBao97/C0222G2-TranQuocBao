import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ContractAddComponent} from './contract-add/contract-add.component';
import {ContractListComponent} from './contract-list/contract-list.component';


let routes : Routes = [
  {path: 'add', component: ContractAddComponent},
  {path: 'list', component: ContractListComponent},
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class ContractRoutingModule { }
