import { Component, OnInit } from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {PackService} from '../../services/pack.service';

@Component({
  selector: 'app-main-list',
  templateUrl: './main-list.component.html',
  styleUrls: ['./main-list.component.css']
})
export class MainListComponent implements OnInit {

  constructor(private mess: ToastrService) { }

  ngOnInit(): void {
  }


}
