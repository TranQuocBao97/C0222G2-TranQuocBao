import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {PackService} from '../../services/pack.service';
import {Pack} from '../../models/Pack';
import {Product} from '../../models/Product';
import {ProductService} from '../../services/product.service';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import * as moment from 'moment';

@Component({
  selector: 'app-pack-edit',
  templateUrl: './pack-edit.component.html',
  styleUrls: ['./pack-edit.component.css']
})
export class PackEditComponent implements OnInit {
  id: any;
  pack: Pack;
  productList: Product[];
  packForm: FormGroup;


  constructor(private activatedRoute: ActivatedRoute,
              private packService: PackService,
              private productService: ProductService,
              private router: Router,
              private mess: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
    }, error => {
    }, () => {
    });
  }

  ngOnInit(): void {
    this.getPackById();
  }

  getPackById() {
    this.packService.getPackById(this.id).subscribe(data => {
      this.pack = data;
    }, error => {
    }, () => {
      this.getProductList();
      this.getFormEditPack();
    });
  }

  getProductList() {
    this.productService.getAllProduct().subscribe(data => {
      this.productList = data;
    });
  }

  getFormEditPack() {
    this.packForm = new FormGroup({
      id: new FormControl(this.pack.id),
      nameId: new FormControl(this.pack.nameId, [Validators.required, Validators.pattern('^LH-[0-9]{4}$')]),
      product: new FormControl(this.pack.product, [Validators.required]),
      amount: new FormControl(this.pack.amount, [Validators.required, Validators.min(1)]),
      dateIn: new FormControl(this.pack.dateIn, [Validators.required, this.validateDate]),
      dateProduct: new FormControl(this.pack.dateProduct, [Validators.required, this.validateDate]),
      dateOver: new FormControl(this.pack.dateOver, [Validators.required, this.validateDate]),
    });
  }

  validateDate(AC: AbstractControl) {
    if (AC && AC.value && !moment(AC.value, 'YYYY-MM-DD', true).isValid()) {
      return {'dateValidator': true};
    }
    return null;
  }

  editPack() {
    this.pack = this.packForm.value;
    this.packService.editPack(this.pack).subscribe(data => {

    }, error => {

    }, () => {
      this.router.navigate(['']);
      this.mess.success('Success!', 'Edit');
    });
  }

  defaultSelectProduct(c1: Product, c2: Product) {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

}
