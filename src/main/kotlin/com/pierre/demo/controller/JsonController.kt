package com.pierre.demo.controller

import com.pierre.demo.model.Cliente
import com.pierre.demo.model.SimpleObject
import com.pierre.demo.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class JsonController {
    
    @GetMapping("/json")
    fun getJson() = SimpleObject()
    
    @GetMapping("/cliente")
    fun getCliente(): Cliente {
        var telefone = Telefone("11","383883883","fixo")
        var cliente = Cliente(1,"pierre", Date(), telefone )
        return cliente
        
    }
}