import { Injectable } from '@angular/core';
import {ServiceBase, PAYMENT_ADD} from "../../common/service.base";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class PaymentService extends ServiceBase {

  constructor(private http: Http) {
    super();
  }

  addPayment(payment, memberId): Observable<any> {
    payment['memberId'] = memberId;
    console.log(`Payment to save: ${JSON.stringify(payment)}`);
    let headers = new Headers({ 'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(PAYMENT_ADD, JSON.stringify(payment), options).map((response: Response) => {
      return response.json();
    }).catch(this.handleError);
  }
}
