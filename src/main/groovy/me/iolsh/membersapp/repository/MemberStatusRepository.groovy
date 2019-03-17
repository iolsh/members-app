package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.MemberStatus

/**
 * MemberStatusRepository
 */
interface MemberStatusRepository extends CrudRepository<MemberStatus, Long> {

}