import {Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html'
})
export class MembersComponent implements OnInit {
  public memberList :any ;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.memberList = this.route.snapshot.data['members'];
  }
}
