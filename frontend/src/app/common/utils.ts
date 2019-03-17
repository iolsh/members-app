import {NgModel} from "@angular/forms";

export class Utils {
   static getError(model : NgModel) {
    if (!model.touched) {
      return;
    }
    let errors : any = model.errors != null ? model.errors : {};
    let message : string;
    console.log('Errors: ' + JSON.stringify(errors));
    if (errors['required']) {
      message =  'Pole jest wymagane';
    } else if (errors['validateEmail']) {
      message =  'Nieprawidłowy adres email';
    } else {
      message = 'Niepoprawna wartość pola'
    }
    return message;
  }
}
