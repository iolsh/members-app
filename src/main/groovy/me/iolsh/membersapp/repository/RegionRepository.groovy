package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Region

/**
 * RegionRepository
 */
interface RegionRepository extends CrudRepository<Region, Long> {
}
