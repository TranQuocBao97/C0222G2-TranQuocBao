import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: Product = {};
  productForm: FormGroup;

  constructor(private productService: ProductService, private activeRoute: ActivatedRoute) {
    activeRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.findById(parseInt(id))[0];
    }, error => {
      console.log(error);
    });

    this.productForm = new FormGroup( {

    })
  }

  ngOnInit(): void {

  }

}
