package com.pierre.demo

import com.pierre.demo.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class DemoKotlinApplication{
	companion object {
		val initialPromocoes = arrayOf(
				Promocao(1, "Maravilosa viagem a Cancun", "Cancun", true, 7, 4999.99),
				Promocao(2, "Viagem Radical com Rapel e escalada", "Cancun", false, 15, 12000.0),
				Promocao(3, "Via espiritual ", "Cancun", false, 12, 1500.0),
				Promocao(4, "Viagem com a faimilia", "Cancun", false, 5, 43500.33)
		
		)
	}
	@Bean
	fun promocoes() =
			ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy (Promocao::id))
	
}

fun main(args: Array<String>) {
	runApplication<DemoKotlinApplication>(*args)
}
