import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: Product = {};
  productForm: FormGroup;

  constructor(private productService: ProductService, private activeRoute: ActivatedRoute, private router: Router) {
    activeRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.findById(parseInt(id))[0];
    }, error => {
      console.log(error);
    });

    this.productForm = new FormGroup( {
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name),
      price: new FormControl(this.product.price),
      description: new FormControl(this.product.description)
    })
  }

  ngOnInit(): void {

  }

  updateProduct() {
    const productEdit =  this.productForm.value;
    this.productService.updateProduct(productEdit);
    this.router.navigateByUrl("product/list");
  }
}
