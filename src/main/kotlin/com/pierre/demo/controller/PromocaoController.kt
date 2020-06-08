package com.pierre.demo.controller
import com.pierre.demo.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.RequestPredicates.POST
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Filter

@RestController
class PromocaoController {
    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>
    
    @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod.GET))
    fun getGetId(@PathVariable id:Long) = promocoes[id]
    
    @RequestMapping(value = ["/promocoes"], method= arrayOf(RequestMethod.POST))
    private fun create(@RequestBody promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }
    @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long){
        promocoes.remove(id)
    }
    @RequestMapping(value = ["/promocoes/{id}"], method = arrayOf(RequestMethod.PUT))
    fun update(id: Long, @RequestBody promocao: Promocao){
        promocoes.remove(id)
        promocoes[id] = promocao
    }
    @RequestMapping(value = ["/promocoes"], method = arrayOf(RequestMethod.GET))
    fun getAll( @RequestParam (required = false, defaultValue = "") localFilter: String) =
           promocoes.filter {
               it.value.local.contains(localFilter, true)
           }.map(Map.Entry<Long, Promocao>::value).toList()
    
    }
    
    
