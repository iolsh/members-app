import { Injectable } from '@angular/core';
import {ServiceBase, ALL_MEMBERS, MEMBER_BY_ID, MEMBER_BY_PESEL, MEMBER_ADD, MEMBER_UPDATE} from "../../common/service.base";
import { Observable } from 'rxjs/Observable';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Injectable()
export class MemberService extends ServiceBase {

  constructor(private http: Http) {
    super();
  }

  getAllMembers():Observable<any[]> {
    return this.http.get(ALL_MEMBERS).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  getMemberById(id:number):Observable<any> {
    return this.http.get(MEMBER_BY_ID + id).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  deleteMemberById(id:number):Observable<any> {
    return this.http.delete(MEMBER_BY_ID + id).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  getMemberByPesel(pesel:string):Observable<any> {
    return this.http.get(MEMBER_BY_PESEL + pesel).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  addMember(member): Observable<any> {
    let headers = new Headers({ 'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(MEMBER_ADD, JSON.stringify(member), options).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

  updateMember(member): Observable<any> {
    let headers = new Headers({ 'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.put(MEMBER_UPDATE, JSON.stringify(member), options).map((response: Response) => {
      return response.json();
    }).catch(super.handleError);
  }

}
