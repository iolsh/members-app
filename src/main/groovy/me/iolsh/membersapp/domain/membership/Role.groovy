package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Role
 */
@Canonical
@Entity
class Role {
    @Id
    Long id
    @Column(unique = true)
    String role
}