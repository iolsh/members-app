import {NgModel} from '@angular/forms';
import {Utils} from './utils';

export class ComponentBase {

  getError(model : NgModel) {
    return Utils.getError(model);
  }

}
