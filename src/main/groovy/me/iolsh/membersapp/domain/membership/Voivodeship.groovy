package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Canonical
@Entity
class Voivodeship {
    @Id
    Long id
    @Column(unique = true)
    String name
    @Column
    String email
    @ManyToOne
    Region region
}
