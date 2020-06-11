package com.pierre.demo.repository

import com.pierre.demo.model.Promocao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository : JpaRepository<Promocao, Long> {
}