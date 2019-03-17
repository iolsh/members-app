package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Currency
 */
@Canonical
@Entity
class Currency {
    @Id
    Long id
    @Column(unique = true)
    String currency
}
