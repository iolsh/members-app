package me.iolsh.membersapp.domain.dto

import groovy.transform.Canonical

@Canonical
class AmountPerCurrency {
    me.iolsh.membersapp.domain.membership.Currency currency;
    BigDecimal sum;
    AmountPerCurrency (me.iolsh.membersapp.domain.membership.Currency currency, BigDecimal sum) {
        this.currency = currency;
        this.sum = sum;
    }

}
