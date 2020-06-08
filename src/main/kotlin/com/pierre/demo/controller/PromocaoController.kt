package com.pierre.demo.controller
import com.pierre.demo.model.Promocao
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PromocaoController {
    @RequestMapping(value = ["/sayHelo"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return  "Bem vindo o kotlin com spring boot"
    }
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.GET))
    fun getPromocao(): Promocao{
        val promocao = Promocao(1,"viagem comun", "Boa vista",true,8,400.90)
        return promocao
    }
}