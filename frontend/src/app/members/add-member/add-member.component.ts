import {Component, OnInit} from '@angular/core';
import {MemberService} from "../shared/member.service";
import {Router} from "@angular/router";
import {ComponentBase} from "../../common/component-base";


declare var $:JQueryStatic;
const VOIVODESHIPS = '/api/dict/voivodeship';
const MSTATUSES = "/api/dict/memberStatus";

export interface IVoivodeship {
  id: number;
  name: string;
}
export interface IMemberStatus {
  id: number;
  status: string;
}

@Component({
  selector: 'app-add-member',
  templateUrl: './add-member.component.html'
})
export class AddMemberComponent extends ComponentBase implements OnInit {

  member: any = {};
  voivodeships: IVoivodeship[];
  mstatuses: IMemberStatus[];

  constructor(private router: Router, private memberService:MemberService) {
    super()
  }

  ngOnInit() {
    this.init();
  }

  init() {
    let self = this;
    $.ajax(VOIVODESHIPS)
      .done(function (data) {
        self.voivodeships = data;
      })
      .fail(function () {
        console.log('Error while fetching voivodeships');
      });
    $.ajax(MSTATUSES)
      .done(function (data) {
        self.mstatuses = data;
      })
      .fail(function () {
        console.log('Error while fetching member statuses');
      });
  }
  saveMember(formValues) {
    this.memberService.addMember(formValues).subscribe(member => {
      console.log('Member: ' + member);
      this.router.navigate(['/members']);
    });
  }

  cancel() {
    this.router.navigate(['/members']);
  }


}
