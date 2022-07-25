import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {Dictionary} from '../model/dictionary';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  // @ts-ignore
  dictionary: Dictionary = {};

  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryServiceService) {
    activatedRoute.paramMap.subscribe( (paramMap: ParamMap) => {
      const word = paramMap.get('word');
      this.dictionary = this.dictionaryService.findByWord(word)[0];
    }, error => {
      console.log(error)
    });
  }

  ngOnInit(): void {
  }

}
