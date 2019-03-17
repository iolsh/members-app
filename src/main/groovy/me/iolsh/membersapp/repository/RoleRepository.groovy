package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Role

/**
 * RoleRepository
 */
interface RoleRepository extends CrudRepository<Role, Long> {

}
