import {Component, OnInit} from '@angular/core';
import {Product} from '../../models/Product';
import {ProductService} from '../../services/product.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {PackService} from '../../services/pack.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import * as moment from 'moment';

@Component({
  selector: 'app-pack-add',
  templateUrl: './pack-add.component.html',
  styleUrls: ['./pack-add.component.css']
})
export class PackAddComponent implements OnInit {
  productList: Product[] = [];
  packForm: FormGroup;


  constructor(private productService: ProductService,
              private packService: PackService,
              private route: Router,
              private mess: ToastrService) {

  }

  ngOnInit(): void {
    this.getFormProduct();
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAllProduct().subscribe(data => {
      this.productList = data;
      console.log(this.productList);
    }, error => {

    }, () => {

    });
  }

  getFormProduct() {
    this.packForm = new FormGroup({
      // id: new FormControl(),
      nameId: new FormControl('', [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]),
      product: new FormControl('', [Validators.required]),
      amount: new FormControl('', [Validators.required, Validators.min(0)]),
      dateIn: new FormControl('', [Validators.required, this.validateDate]),
      dateProduct: new FormControl('', [Validators.required, this.validateDate]),
      dateOver: new FormControl('', [Validators.required, this.validateDate]),
    });
  }

  validateDate(AC: AbstractControl) {
    // @ts-ignore
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return {'dateValidator': true};
    }
    return null;
  }

  getNumberDaysRent(startDateString, endDateString) {
    let day = 1000 * 60 * 60 * 24;
    let startDate = new Date(startDateString);
    let endDate = new Date(endDateString);
    let startDays = Math.round(startDate.getTime() / day);
    let endDays = Math.round(endDate.getTime() / day);
    if(endDays - startDays > 0){
      return true;
    }
    return false;
  }

  addPack() {
    console.log(this.packForm.value);
    if (this.packForm.valid) {
      this.packService.addPack(this.packForm.value).subscribe(data => {

      }, error => {

      }, () => {
        this.route.navigate(['']);
        this.mess.success('Thêm mới', 'Thành công');
      });
    } else {
      this.packForm.markAllAsTouched();
      this.mess.error('Thêm mới', 'Thất bại');
    }
  }
}
