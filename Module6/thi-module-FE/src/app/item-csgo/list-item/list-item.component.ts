import {Component, DoCheck, OnDestroy, OnInit} from '@angular/core';
import {ItemCsgoService} from '../service/item-csgo.service';
import {Item} from '../model/Item';
import {ToastrService} from 'ngx-toastr';
import {ItemOfInventory} from '../model/ItemOfInventory';


declare const test: any;

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit, OnDestroy, DoCheck {
  itemCsgoList: Item[] = [];
  itemInventoryList: ItemOfInventory[] = [];
  getData: any;
  id: any = 0;


  constructor(private itemCsgoService: ItemCsgoService,
              private mess: ToastrService) {

  }

  ngOnInit(): void {
    // this.getAllItemCsgo();
    this.getItemInventory();
  }

  connectAPI() {
    this.getPriceItemCsgo();
  }

  myTest() {
    test();
  }

  getItemInventory(){
    this.itemCsgoService.getItemOfInventory().subscribe( data => {
      this.itemInventoryList = data;
    }, error => {

    }, () => {

    })
  }

  getAllItemCsgo() {
    this.itemCsgoService.getAllItemCsgoWithList().subscribe(data => {
      this.itemCsgoList = data;
      for (const test of this.itemCsgoList) {
      }
    }, error => {

    }, () => {

    });
  }

  getPriceItemCsgo() {
    this.getData = setInterval(() => {
      this.getPriceForOneItemCsgo(this.itemCsgoList[this.id]);
      this.id++;
      console.log('id = ' + this.id);
    }, 15000);

  }

  ngOnDestroy() {
    if (this.id >= this.itemCsgoList.length) {
      clearInterval(this.getData);
    }
  }

  sleep(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  getPriceForOneItemCsgo(itemCsgo) {
    this.itemCsgoService.getPriceCsgoItem(itemCsgo.name).subscribe(data => {
      console.log(itemCsgo.name);
      if(data.lowest_price == null && itemCsgo.lowestPrice == null){
        itemCsgo.lowestPrice = 0;
      }else {
        itemCsgo.lowestPrice = data.lowest_price.slice(1);
      }
      if(data.median_price == null && itemCsgo.medianPrice == null){
        itemCsgo.lowestPrice = 0;
      }else {
        itemCsgo.medianPrice = data.median_price.slice(1);
      }
      console.log('Status = ' + data.success);
    }, error => {
      console.log('Lỗi = ' + error.status);
      if (error.status == 429) {
        (async () => {
          this.mess.error('Dừng vì lỗi', 'ERROR 429');
          this.pause();
          await this.sleep(10800000);
          this.mess.info('Tiếp tục', 'END PAUSE ERROR');
          this.continue();
        })();
      } else {
        this.getPriceForOneItemCsgo(itemCsgo);
      }
    }, () => {
      console.log('lowestPrice = ' + itemCsgo.lowestPrice);
      console.log('medianPrice = ' + itemCsgo.medianPrice);
      console.log('Kết thúc với id = ' + this.id);
    });
  }

  saveToDataBase() {
    this.itemCsgoService.saveAllToDataBase(this.itemCsgoList).subscribe(data => {

    }, error => {
      this.mess.error('lỗi', 'LỖI');
    }, () => {
      this.mess.success('thành công', 'thành công');
    });
  }

  ngDoCheck(): void {
    if (this.id >= this.itemCsgoList.length) {
      clearInterval(this.getData);
    }
  }

  pause(): void {
    clearInterval(this.getData);
    this.mess.warning('Đã dừng', 'Pause');
  }

  continue(): void {
    this.getPriceItemCsgo();
    this.mess.warning('Tiếp tục', 'Continue');
  }


}
