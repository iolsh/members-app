package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Voivodeship

/**
 * VoivodeshipRepository
 */
interface VoivodeshipRepository extends CrudRepository<Voivodeship , Long> {

}