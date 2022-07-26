import { Component, OnInit } from '@angular/core';
import {Contract} from '../../models/Contract';
import {Subscription} from 'rxjs';
import {ContractService} from '../../services/contract.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contractList : Contract[] = [];
  private subscriptions: Subscription;
  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.getAllContract();
  }

  getAllContract(){
    this.contractService.getAllContracts().subscribe( data =>{
      this.contractList = data;

    }, error => {

    }, () => {
      console.log(this.contractList);
    })
  }

}
