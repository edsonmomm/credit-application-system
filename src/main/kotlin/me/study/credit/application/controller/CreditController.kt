package me.study.credit.application.controller

import me.study.credit.application.model.Credit
import me.study.credit.application.model.dto.request.CreditDTO
import me.study.credit.application.model.dto.response.CreditView
import me.study.credit.application.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody creditDTO: CreditDTO): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.save(creditDTO.toEntity())
        return ResponseEntity(CreditView(credit), HttpStatus.CREATED)
    }

    @GetMapping("/findAllByCustomerId")
    fun findALlByCustomerId(@RequestParam customerId: Long): ResponseEntity<List<CreditView>> {
        return ResponseEntity(this.creditService.findAllByCustomer(customerId)
            .stream()
            .map {credit: Credit -> CreditView(credit) }
            .collect(Collectors.toList())
        ,HttpStatus.OK)
    }

    @GetMapping("/creditCode")
    fun findByCreditCode(@RequestParam customerId: Long, @RequestParam creditCode: UUID): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity(CreditView(credit), HttpStatus.OK)
    }
}