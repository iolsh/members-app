import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MemberService} from '../shared/member.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html'
})
export class DetailsComponent implements OnInit {

  member: any;

  constructor(private router: Router, private route: ActivatedRoute, private memberService: MemberService) { }

  ngOnInit() {
    this.route.data.forEach((data) => {
      console.log('Data: ' + JSON.stringify(data));
      this.member = data['member'];
    });
  }

  deleteMember() {
    this.memberService.deleteMemberById(this.member['id']).subscribe(() => {
      this.router.navigate(['/members']);
    });
  }

}
