import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {Dictionary} from '../model/dictionary';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.css']
})
export class DictionayPageComponent implements OnInit {
  dictionaryList: Dictionary[];


  constructor(private dictionaryService: DictionaryServiceService) {
  }

  ngOnInit(): void {
    this.dictionaryList = this.dictionaryService.getAll();
  }

  searchByWord(searchForm: NgForm) {
    this.dictionaryList = this.dictionaryService.findBySameWord(searchForm.value.word);
  }
}
