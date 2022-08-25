import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ListProductComponent } from './list-product/list-product.component';
import { AddProductComponent } from './add-product/add-product.component';
import {ShareModule} from '../share/share.module';


@NgModule({
  declarations: [ListProductComponent, AddProductComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ShareModule
  ]
})
export class ProductModule { }
