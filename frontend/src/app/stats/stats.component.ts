import {Component, OnInit} from '@angular/core';
import {StatsService} from "./stats.service";
export interface AmountByCurrency {
  currency: string;
  sum: number;
}
@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html'
})
export class StatsComponent implements OnInit {

  newCnt: number;
  paymentsByCurrency: Array<AmountByCurrency> = new Array<AmountByCurrency>();

  constructor(private stats: StatsService) { }

  ngOnInit() {
    this.stats.getPaymentsByCurrency().subscribe((byCurrency) => {
      this.paymentsByCurrency = byCurrency;
      //console.log(`PaymentsByCurrency: ${JSON.stringify(this.paymentsByCurrency)}`)
    });
    this.stats.getNewMambersCnt().subscribe((cnt) => {
      this.newCnt = cnt;
    });

  }


}
