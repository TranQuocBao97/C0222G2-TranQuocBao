import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {PackService} from '../../services/pack.service';
import {Pack} from '../../models/Pack';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-pack-list',
  templateUrl: './pack-list.component.html',
  styleUrls: ['./pack-list.component.css']
})
export class PackListComponent implements OnInit {
  packList: Pack[] = [];
  nameDelete: string;
  idDelete: number;
  dateInDelete : string;
  searchForm: FormGroup;
  checkFirstPage: boolean;
  checkNextPage: boolean;
  numberPage: number = 0;

  constructor(private mess: ToastrService,
              private packService: PackService) {
  }

  ngOnInit(): void {
    this.getAllPack(this.numberPage);
    this.formSearch();
  }

  getAllPack(numberPage) {
    this.packService.getAllPackWithPage(numberPage).subscribe(data => {
      // @ts-ignore
      this.packList = data.content;
      console.log(this.packList);
      // @ts-ignore
      this.checkFirstPage = data.first;
      // @ts-ignore
      this.checkNextPage = data.last;
    });
  }
  nextPage() {
    this.numberPage+=1;
    this.getAllPack(this.numberPage);
  }

  previousPage() {
    this.numberPage-=1;
    this.getAllPack(this.numberPage);
  }

  showDelete(pack: Pack) {
    this.idDelete = pack.id;
    this.nameDelete = pack.product.name;
    this.dateInDelete = pack.dateIn;
  }

  deletePack() {
    this.packService.deletePackById(this.idDelete).subscribe( data => {

    }, error => {

    }, () => {
      this.ngOnInit();
      this.mess.success('Xóa', 'Thành công')
    })
  }

  formSearch(){
    this.searchForm = new FormGroup({
      productNameSearch: new FormControl(""),
      dateOverSearch: new FormControl("")
    });
  }

  getFormSearch() {
    this.packService.search(this.searchForm.value.productNameSearch,this.searchForm.value.dateOverSearch).subscribe(data => {
      this.packList = data;
      console.log(data);
    }, error => {

    }, () => {

    })
  }

}
