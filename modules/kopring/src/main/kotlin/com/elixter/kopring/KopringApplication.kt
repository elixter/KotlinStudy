package com.elixter.kopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties
@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = ["com.elixter"])
class KopringApplication

fun main(args: Array<String>) {
	runApplication<KopringApplication>(*args)
}
