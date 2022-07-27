import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-paging',
  templateUrl: './paging.component.html',
  styleUrls: ['./paging.component.css']
})
export class PagingComponent implements OnInit {
  p: number = 1;
  collection: any[] = [];
  totalItems: number;
  constructor(private productService: ProductService) {
    this.productService.getAll().subscribe(data => {
      this.collection = data;
      this.totalItems = data.length;
    })
  }

  ngOnInit(): void {
  }

}
