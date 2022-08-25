import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from '../service/product-type.service';
import {ToastrService} from 'ngx-toastr';
import {ProductService} from '../service/product.service';
import {Router} from '@angular/router';
import {ProductType} from '../model/product-type';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import * as moment from 'moment';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  productTypeList: ProductType[] = [];
  productForm: FormGroup;
  selectedOption: number = 0;

  constructor(private mess: ToastrService,
              private productService: ProductService,
              private productTypeService: ProductTypeService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.getAllProductType();
    this.getFormProduct();
  }

  getAllProductType() {
    this.productTypeService.getAllProductType().subscribe(data => {
      this.productTypeList = data;
    });
  }

  getFormProduct() {
    this.productForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      code: new FormControl('', [Validators.required, Validators.pattern('^SP-[0-9]{3}$')]),
      price: new FormControl('',[Validators.required, Validators.min(1), Validators.pattern('^[1-9][0-9]+$')]),
      company: new FormControl(''),
      dateCreateProduct: new FormControl(null, [Validators.required, this.validateDate]),
      isGas: new FormControl(false),
      cakeSugar: new FormControl(false),
      writer: new FormControl(''),
      bookType: new FormControl(''),
      dateCreateBook: new FormControl(null,[Validators.required, this.validateDate]),
      status : new FormControl('', [Validators.required]),
      productType: new FormControl(''),
    });
  }

  validateDate(AC: AbstractControl) {
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return {'dateValidator': true};
    }
    return null;
  }


  addProduct() {
    this.productService.addProduct(this.productForm.value).subscribe(data => {

    }, error => {
      this.productForm.markAllAsTouched();
      this.mess.warning('Thất bại', 'Thêm mới');
    }, () => {
      this.route.navigate(['/product']);
      this.mess.success('Thành công', 'Thêm mới');
    });
  }

  showAddForm() {
    console.log(this.selectedOption);
    this.ngOnInit();
  }
}
