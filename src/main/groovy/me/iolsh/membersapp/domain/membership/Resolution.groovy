package me.iolsh.membersapp.domain.membership

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Canonical
@Entity
class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Column
    String resolutionId
    @Column
    Date resolutionDate
    @Column
    String attachementId
    @Column
    String issuer
    @Column
    String remarks
    @OneToMany(mappedBy = "resolutionId",fetch = FetchType.EAGER)
    List<Member> members
}
