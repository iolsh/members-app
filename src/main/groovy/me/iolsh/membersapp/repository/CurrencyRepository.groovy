package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Currency

/**
 * CurrencyRepository
 */
interface CurrencyRepository extends CrudRepository<Currency, Long> {

}
