import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {

  dictionaryList: Dictionary[] = [
    {word: 'Apple',mean: 'Táo'},
    {word: 'Car',mean: 'Xe hơi'},
    {word: 'Computer',mean: 'Máy tính'},
    {word: 'Music',mean: 'Nhạc'}
  ];

  constructor() { }

  getAll() {
    return this.dictionaryList
  }

  findByWord(word: string) {
    return this.dictionaryList.filter( letter => letter.word === word)
  }

  findBySameWord(sameWord: string) {
    return this.dictionaryList.filter( letter => letter.word.includes(sameWord));
  }

}
