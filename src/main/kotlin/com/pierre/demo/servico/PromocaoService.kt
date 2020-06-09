package com.pierre.demo.servico

import com.pierre.demo.model.Promocao
import org.springframework.context.annotation.Bean

interface PromocaoService {
    fun create(promocao: Promocao)
    fun getById(id: Long): Promocao?
    fun delete(id: Long)
    fun update(id: Long, promocao:Promocao)
    fun searchByLocal(local: String): List<Promocao>
}