import { Observable } from 'rxjs/Observable';
import {Response } from '@angular/http';

export const ALL_MEMBERS ='/api/m/a';
export const MEMBER_BY_ID = '/api/m/i/';
export const MEMBER_BY_PESEL = '/api/m/p/';
export const MEMBER_ADD = '/api/m/add/';
export const MEMBER_UPDATE = '/api/m/save/';
export const NEW_MEMBERS_CNT = '/api/m/nc/';
export const PAYMENT_ADD = '/api/p/add/';
export const PAYMENTS_BY_CURRENCY = '/api/p/bc';

export class ServiceBase {

  handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

}
