package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Member

interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByPesel(String pesel)

}