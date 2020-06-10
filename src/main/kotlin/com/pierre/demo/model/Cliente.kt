package com.pierre.demo.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Cliente (val id: Long,
                    val nome: String,
                    @JsonFormat(shape = JsonFormat.Shape.STRING,
                    pattern = "dd/MM/YYYY")
                    val dataNascimento: Date,
                    var telefone: Telefone?)

@JsonIgnoreProperties("tipo")
data class Telefone(val ddd: String="", val numero : String, @JsonIgnore val tipo: String= "")

