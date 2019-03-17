package me.iolsh.membersapp.repository

import org.springframework.data.repository.CrudRepository
import me.iolsh.membersapp.domain.membership.Payment
import me.iolsh.membersapp.domain.membership.Currency

interface PaymentRepository extends CrudRepository<Payment, Long> {
    Payment findByMemberId(long memberId);
    List<Payment> findByCurrency(Currency currency)
}