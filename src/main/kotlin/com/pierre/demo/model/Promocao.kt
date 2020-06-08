package com.pierre.demo.model

data class Promocao (
        val id: Long,
        val descricao: String,
        val local: String,
        val isAllInclusive: Boolean,
        val qQtDias: Int,
        val preco: Double
)