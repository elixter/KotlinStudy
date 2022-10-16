package com.elixter.kopring.config.filter

import mu.KLogging
import org.slf4j.MDC
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
@Order(2)
class MdcFilter : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        logger.debug { "[MdcFilter]" }
        // TODO: need to apply usage of MDC with webflux
        with(exchange.request) {
            MDC.put(REQUEST_METHOD, this.method.toString())
            MDC.put(REQUEST_URI, this.uri.toString())
        }

        return chain.filter(exchange)
    }

    companion object : KLogging() {
        val REQUEST_METHOD = "requestMethod"
        val REQUEST_URI = "requestUri"
    }
}