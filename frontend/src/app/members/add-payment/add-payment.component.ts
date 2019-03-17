import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {PaymentService} from "../shared/payment.service";

declare var $:JQueryStatic;
const PAYMENT_TYPES = '/api/dict/paymentType';
const CURRENCIES = '/api/dict/currency';

export interface IPaymentType {
  id: number;
  type: string;
}

export interface ICurrency {
  id: number;
  currency: string;
}

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
})
export class AddPaymentComponent implements OnInit {

  memberId;
  payment: any = {};
  paymentTypes : IPaymentType[];
  currencies: ICurrency[];

  constructor(private router: Router, private route: ActivatedRoute, private paymentService : PaymentService) { }

  ngOnInit() {
    this.route.data.forEach((data) => {
      console.log('Data: ' + JSON.stringify(data));
      this.memberId = data['mid'];
    });
    this.init();
  }

  savePayment(formValues) {
    this.paymentService.addPayment(formValues, this.memberId).subscribe(payment => {
      this.router.navigate(['/members', this.memberId]);
    });
  }

  cancel() {
    this.router.navigate(['/members', this.memberId]);
  }

  datePickerOptions : any = {
    selectMonths: true,//Creates a dropdown to control month
    selectYears: 3,//Creates a dropdown of 15 years to control year
    //The title label to use for the month nav buttons
    labelMonthNext: 'Następny miesiąc',
    labelMonthPrev: 'Poprzedni miesiąc',
    //The title label to use for the dropdown selectors
    labelMonthSelect: 'Wybierz miesiąc',
    labelYearSelect: 'Wybierz rok',
    //Months and weekdays
    monthsFull: [ 'Styczeń', 'Luty', 'Marzec', 'Kwiecień', 'Maj', 'Czerwiec', 'Lipiec', 'Sierpień',
      'Wrzesień', 'Pażdziernik', 'Listopad', 'Grudzień' ],
    monthsShort: [ 'STY', 'LUT', 'MAR', 'KWI', 'MAJ', 'CZE', 'LIP', 'SIE', 'WRZ', 'PAŹ', 'LIS', 'GRU' ],
    weekdaysFull: [ 'Niedziela', 'Poniedziałek', 'Wtorek', 'Środa', 'Czwartek', 'Piątek', 'Sobota' ],
    weekdaysShort: [ 'Niedz.', 'Pon.', 'Wt.', 'Śr.', 'Czw.', 'Pt.', 'Sob.' ],
    //Materialize modified
    weekdaysLetter: [ 'N', 'P', 'W', 'Ś', 'C', 'P', 'S' ],
    //Today and clear
    today: 'Dzisiaj',
    clear: 'Wyczyść',
    close: 'Zamknij',
    //The format to show on the `input` element
    format: 'yyyy-mm-dd'
  }

  init() {
    let self = this;
    $.ajax(PAYMENT_TYPES)
      .done(function (data) {
        self.paymentTypes = data;
      })
      .fail(function () {
        console.log('Error while fetching payment types');
      });
    $.ajax(CURRENCIES)
      .done(function (data) {
        self.currencies = data;
      })
      .fail(function () {
        console.log('Error while fetching currencies');
      });
  }
}
