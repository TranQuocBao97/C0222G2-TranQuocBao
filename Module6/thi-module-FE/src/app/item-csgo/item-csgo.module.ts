import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItemCsgoRoutingModule } from './item-csgo-routing.module';
import {ShareModule} from '../share/share.module';
import { ListItemComponent } from './list-item/list-item.component';


@NgModule({
  declarations: [ListItemComponent],
  imports: [
    CommonModule,
    ItemCsgoRoutingModule,
    ShareModule
  ]
})
export class ItemCsgoModule { }
