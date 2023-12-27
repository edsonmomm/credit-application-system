package me.study.credit.application.exception

open class BusinessException(override val message: String?): RuntimeException(message)
