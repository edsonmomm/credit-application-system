package me.study.credit.application.service.impl

import me.study.credit.application.exception.BusinessException
import me.study.credit.application.model.Credit
import me.study.credit.application.repository.CreditRepository
import me.study.credit.application.service.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("CreditCode $creditCode was not found.")

        if (credit.customer?.id == customerId)
            return credit
        else
            throw BusinessException("Credit does not belong to customer, contact admin for support")
    }

    /**
     * First day of Installment can only be from today and 3 months further
     */
    private fun validDayFirstInstallment(dayFirstInstallment: LocalDate): Boolean {
        return if (dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))
            && dayFirstInstallment.isAfter(LocalDate.now().minusDays(1))) true
        else throw BusinessException("First day of Installment can only be from today and 3 months further")
    }
}