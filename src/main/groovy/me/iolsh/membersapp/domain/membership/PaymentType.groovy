package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * PaymentType
 */
@Canonical
@Entity
class PaymentType {

    @Id
    Long id

    @Column(unique = true)
    String type

}
