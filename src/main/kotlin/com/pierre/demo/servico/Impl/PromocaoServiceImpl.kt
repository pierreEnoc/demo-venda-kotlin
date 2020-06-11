package com.pierre.demo.servico.Impl

import com.pierre.demo.model.Promocao
import com.pierre.demo.repository.PromocaoRepository
import com.pierre.demo.servico.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl (val promocaoRepository: PromocaoRepository): PromocaoService{
    
    override fun create(promocao: Promocao) {
        this.promocaoRepository.save(promocao)
    }
    
    
    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findById(id).orElseGet(null)
    }
    
    override fun delete(id: Long) {
        this.promocaoRepository.delete(Promocao(id = id ))
    }
    
    override fun update(id: Long, promocao: Promocao) {
         create(promocao)
    }
    
    override fun searchByLocal(local: String): List<Promocao> =
           listOf()
    
    override fun getAll(): List<Promocao> {
      return  this.promocaoRepository.findAll()
    }
}
    
