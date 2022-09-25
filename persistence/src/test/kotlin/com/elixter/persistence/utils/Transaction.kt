package com.elixter.persistence.utils

import org.springframework.stereotype.Component
import org.springframework.transaction.reactive.TransactionalOperator
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class Transaction(
    private val rxtx: TransactionalOperator
) {

    fun <T> withRollback(publisher: Mono<T>): Mono<T> =
        rxtx.execute { tx ->
            tx.setRollbackOnly()
            return@execute publisher
        }.next()

    fun <T> withRollback(publisher: Flux<T>): Flux<T> =
        rxtx.execute {tx ->
            tx.setRollbackOnly()
            return@execute publisher
        }
}