package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Canonical
@Entity
class Region {
    @Id
    Long id
    @Column(unique = true)
    String name
    @Column
    String leadership
}
