import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ToastrService} from 'ngx-toastr';
import {ProductService} from '../service/product.service';
import {ProductTypeService} from '../service/product-type.service';
import {ProductType} from '../model/product-type';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {
  productList: Product[] = [];
  productTypeList: ProductType[] = [];
  idDelete: number;
  nameDelete: string;
  codeDelete: string;
  numberPage: number = 0;
  checkFirstPage: boolean;
  checkNextPage: boolean;
  searchType: number = 0 ;
  page: number = 1;
  selectedOption: number = 0;

  constructor(private mess: ToastrService,
              private productService: ProductService,
              private productTypeService : ProductTypeService) {
    this.getAllProductList();
    this.getAllProductType();
  }

  ngOnInit(): void {

  }


  getAllProduct(numberPage) {
    this.productService.getAllProductWithPage(numberPage).subscribe(data => {
      // @ts-ignore
      this.productList = data.content;
      // @ts-ignore
      console.log(data.content);
      console.log(this.productList);
      // @ts-ignore
      this.checkFirstPage = data.first;
      // @ts-ignore
      this.checkNextPage = data.last;
    });
  }


  getAllProductList(){
    this.productService.getAllProductWithList().subscribe( data => {
      this.productList = data;
    })
  }


  getAllProductType(){
    this.productTypeService.getAllProductType().subscribe(data => {
      this.productTypeList = data;
    })
  }

  showDelete(product: Product) {
    this.idDelete = product.id;
    this.codeDelete =  product.code;
    this.nameDelete = product.name;
  }

  deleteProduct() {
    this.productService.deleteProductById(this.idDelete).subscribe( data => {
    }, error => {
      this.mess.warning('Thất bại', 'Xóa')
    }, () => {
      this.ngOnInit();
      this.mess.success('Thành công', 'Xóa')
    })
  }

  changeListBySearch(){
    console.log(this.selectedOption);
    if(this.selectedOption == 0){
      this.getAllProductList();
    }
    if(this.selectedOption == 1){
      this.getAllProductList();
      this.productService.getAllProductWithList().subscribe( data => {
        this.productList = data;
        this.productList = this.productList.filter( value =>
          value.productType.id == 1)
      })
    }
    if(this.selectedOption == 2){
      this.getAllProductList();
      this.productService.getAllProductWithList().subscribe( data => {
        this.productList = data;
        this.productList = this.productList.filter( value =>
          value.productType.id == 2)
      })
    }
    if(this.selectedOption == 3){
      this.getAllProductList();
      this.productService.getAllProductWithList().subscribe( data => {
        this.productList = data;
        this.productList = this.productList.filter( value =>
          value.productType.id == 3)
      })
    }
    console.log(this.productList)
  }

  nextPage() {
    this.numberPage+=1;
    this.getAllProduct(this.numberPage);
  }

  previousPage() {
    this.numberPage-=1;
    this.getAllProduct(this.numberPage);
  }

}
