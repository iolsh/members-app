package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Canonical
@Entity
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Column(unique = true)
    String pesel
    @Column
    String firstNames
    @Column
    String sureName
    @Column
    String town
    @OneToOne
    Voivodeship voivodeship
    @Column
    String postalCode
    @Column
    String street
    @Column
    String streetNumber
    @Column
    String phone
    @Column(unique = true)
    String email
    @Column
    Date submission
    @Column
    Long resolutionId
    @Column
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "memberId",fetch = FetchType.EAGER)
    List<Payment> payments
    @OneToOne
    MemberStatus state
    @OneToOne
    Role role
    @Column
    String oldDbId
    @Column
    boolean active = true
    @Column
    Date updated
    Member() {
    }

}
