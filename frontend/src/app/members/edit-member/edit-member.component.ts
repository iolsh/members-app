import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MemberService} from "../shared/member.service";
import {ComponentBase} from "../../common/component-base";
import {IMemberStatus, IVoivodeship} from "../add-member/add-member.component";
declare var $:JQueryStatic;
const VOIVODESHIPS = '/api/dict/voivodeship';
const MSTATUSES = "/api/dict/memberStatus";

@Component({
  selector: 'app-edit-member',
  templateUrl: './edit-member.component.html'
})
export class EditMemberComponent extends ComponentBase implements OnInit {
  member : any;
  voivodeships: IVoivodeship[];
  mstatuses: IMemberStatus[];

  constructor(private route: ActivatedRoute, private router: Router, private memberService:MemberService) {
    super()
  }

  ngOnInit() {
    this.init();
    this.route.data.forEach((data) => {
      console.log('Data: ' + JSON.stringify(data));
      this.member = data['member'];
    });
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

  updateMember(formValues) {
    console.log('FormValues: ' + JSON.stringify(formValues));
    this.memberService.updateMember(formValues).subscribe(() => {
      this.router.navigate(['/members', this.member['id']]);
    });
  }

  cancel() {
    this.router.navigate(['/members', this.member['id']]);
  }


}
