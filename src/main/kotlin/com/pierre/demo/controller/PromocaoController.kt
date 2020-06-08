package com.pierre.demo.controller
import com.pierre.demo.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {
    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>
    
    @RequestMapping(value = ["/sayHelo"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
        return  "Bem vindo o kotlin com spring boot"
    }
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.GET))
    fun getPromocao() = promocoes[2]
    
    }
