import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';
import {NotificationService} from '../../service/notification.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });
  categories: Category[] = [];

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private notificationService: NotificationService) {
  }

  ngOnInit() {
    this.getAllCategory();
  }

  submit() {
    const product = this.productForm.value;
    if(this.productForm.valid){}
    this.productService.saveProduct(product).subscribe(() => {
        this.notificationService.showSuccess('Thành công','ADD NEW')
        this.productForm.reset();
      }, e => console.log(e)
      , () => {
        this.ngOnInit();
      });
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categoires => {
      this.categories = categoires;
    });
  }
}
