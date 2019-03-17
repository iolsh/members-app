package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import javax.persistence.OneToOne

@Canonical
@Entity
class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Column
    Long memberId
    @OneToOne
    PaymentType type
    @Column
    BigDecimal amount
    @OneToOne
    Currency currency
    @Column
    Date paymentDate
}
