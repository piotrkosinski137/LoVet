import {Component} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  template: '<app-layout></app-layout>'
})
export class AppComponent {

  constructor(private translate: TranslateService) {
    translate.setDefaultLang('en');
  }
}
