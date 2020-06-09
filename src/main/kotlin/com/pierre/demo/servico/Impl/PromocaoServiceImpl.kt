package com.pierre.demo.servico.Impl

import com.pierre.demo.model.Promocao
import com.pierre.demo.servico.PromocaoService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl : PromocaoService {
    companion object {
        val initialPromocoes = arrayOf(
                Promocao(1, "Maravilosa viagem a Cancun", "Cancun", true, 7, 4999.99),
                Promocao(2, "Viagem Radical com Rapel e escalada", "Cancun", false, 15, 12000.0),
                Promocao(3, "Via espiritual ", "Cancun", false, 12, 1500.0),
                Promocao(4, "Viagem com a faimilia", "Cancun", false, 5, 43500.33)
        
        )
    }
    
    var promocoes  =
            ConcurrentHashMap<Long,Promocao>(initialPromocoes.associateBy(Promocao::id))
    
    override fun create(promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }
    
    
    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }
    
    override fun delete(id: Long) {
        promocoes.remove(id)
    }
    
    override fun update(id: Long, promocao: Promocao) {
        delete(id)
        create(promocao)
    }
    
    override fun searchByLocal(local: String): List<Promocao> =
            promocoes.filter {
                it.value.local.contains(local, true)
            }.map (Map.Entry<Long,Promocao>::value).toList()
    }
    
