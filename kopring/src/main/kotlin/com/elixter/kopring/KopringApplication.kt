package com.elixter.kopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans

@EnableConfigurationProperties
@ConfigurationPropertiesScan
@ComponentScan(basePackages = ["com.elixter"])
@SpringBootApplication
class KopringApplication

fun main(args: Array<String>) {
	runApplication<KopringApplication>(*args)
}
