package com.elixter.persistence

import com.elixter.persistence.utils.TransactionHelper
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.transaction.reactive.TransactionalOperator

@TestConfiguration
class TestConfig {

    @Bean
    fun transactionHelper(transactionalOperator: TransactionalOperator): TransactionHelper {
        return TransactionHelper(transactionalOperator)
    }
}