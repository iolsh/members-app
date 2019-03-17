import { Injectable } from '@angular/core';
import {
  ServiceBase, PAYMENTS_BY_CURRENCY, NEW_MEMBERS_CNT
} from "../common/service.base";
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import {AmountByCurrency} from "./stats.component";

@Injectable()
export class StatsService extends ServiceBase {

  constructor(private http: Http) {
    super();
  }

  getPaymentsByCurrency():Observable<AmountByCurrency[]> {
    return this.http.get(PAYMENTS_BY_CURRENCY).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  getNewMambersCnt():Observable<number> {
    return this.http.get(NEW_MEMBERS_CNT).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }


}
