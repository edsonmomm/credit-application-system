package me.study.credit.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditApplicationSystemApplication

fun main(args: Array<String>) {
	println("works")
	runApplication<CreditApplicationSystemApplication>(*args)
}
