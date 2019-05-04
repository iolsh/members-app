import { Injectable } from '@angular/core';
import {Resolve, ActivatedRouteSnapshot} from '@angular/router';

@Injectable()
export class MemberIdResolverService implements Resolve<number> {

  constructor() { }

  resolve(route: ActivatedRouteSnapshot) {
    return +(route.params['memberId']);
  }
}
