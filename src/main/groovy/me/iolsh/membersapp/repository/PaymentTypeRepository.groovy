package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.PaymentType

/**
 * PaymentTypeRepository
 */
interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {

}