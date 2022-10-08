package com.elixter.kopring.config.filter

import com.elixter.kopring.config.filter.RequestConstants.REQUEST_ID_HEDAER
import mu.KLogging
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
@Order(1)
class RequestIdFilter : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        logger.debug { "[RequestIdFilter]" }
        val requestId = exchange.request.id
        exchange.response.headers.set(REQUEST_ID_HEDAER, requestId)

        return chain.filter(exchange)
    }

    companion object : KLogging()
}