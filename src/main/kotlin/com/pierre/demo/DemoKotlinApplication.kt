package com.pierre.demo

import com.pierre.demo.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class DemoKotlinApplication
	
	fun main(args: Array<String>) {
		runApplication<DemoKotlinApplication>(*args)
	}

