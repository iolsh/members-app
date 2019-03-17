import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div>
        <app-navigation></app-navigation>
        <main>
            <router-outlet></router-outlet>
        </main>
    </div>
  `
})
export class AppComponent {
  constructor() {}
}
