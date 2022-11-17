import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from '../model/Item';
import {Price} from '../model/Price';
import {ItemOfInventory} from '../model/ItemOfInventory';


@Injectable({
  providedIn: 'root'
})
export class ItemCsgoService {


  private readonly API_URL = 'http://localhost:8080/item/';
  private readonly API_PRICE_ITEM = 'https://steamcommunity.com/market/priceoverview/?currency=1&appid=730&market_hash_name=';
  private readonly API_INVENTORY = 'https://steamcommunity.com/profiles/76561198075951865/inventory/json/570/2/';

  constructor(private httpClient: HttpClient) {
  }

  getItemOfInventory():  Observable<ItemOfInventory[]> {
    return this.httpClient.get<ItemOfInventory[]>(this.API_INVENTORY);
  }

  getAllItemCsgoWithList(): Observable<Item[]> {
    return this.httpClient.get<Item[]>(this.API_URL);
  }


  getPriceCsgoItem(name: string): Observable<Price> {
    return this.httpClient.get<Price>(this.API_PRICE_ITEM + name);
  }


  saveAllToDataBase(items: Item[]): Observable<Item[]> {
    return this.httpClient.patch<Item[]>(this.API_URL, items);
  }

  updateOne(item: Item): Observable<Item> {
    return this.httpClient.put<Item>(this.API_URL + 'update-one', item);
  }

}
