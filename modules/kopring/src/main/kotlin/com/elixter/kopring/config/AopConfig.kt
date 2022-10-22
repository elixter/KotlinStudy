package com.elixter.kopring.config

import com.elixter.kopring.aop.LogExecutionTimeAspect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy(exposeProxy = true)
@Configuration
class AopConfig {

    @Bean
    fun logExecutionTime(): LogExecutionTimeAspect = LogExecutionTimeAspect()
}