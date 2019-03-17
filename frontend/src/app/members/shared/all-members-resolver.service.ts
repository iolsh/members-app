import { Injectable } from '@angular/core';
import {Resolve, ActivatedRouteSnapshot} from "@angular/router";
import {MemberService} from "./member.service";

@Injectable()
export class AllMembersResolverService implements Resolve<any> {

  constructor(private memberService:MemberService) { }

  resolve(route: ActivatedRouteSnapshot) {
    return this.memberService.getAllMembers();
  }

}
