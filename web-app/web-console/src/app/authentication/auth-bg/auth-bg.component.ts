import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-auth-bg',
  template: `
  <nb-layout>
      <nb-layout-column>
        <nb-card>
          <nb-card-body style="margin:auto;margin-bottom: 14%; margin-top: 13%;">
            <nb-auth-block>
              <router-outlet></router-outlet>
            </nb-auth-block>
          </nb-card-body>
        </nb-card>
      </nb-layout-column>
    </nb-layout>
    `,
  styleUrls: ['./auth-bg.component.scss']
})
export class AuthBgComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
