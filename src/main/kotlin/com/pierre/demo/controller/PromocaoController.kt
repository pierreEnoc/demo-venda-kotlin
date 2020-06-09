package com.pierre.demo.controller
import com.pierre.demo.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.RequestPredicates.POST
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Filter

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {
    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>
    
    @GetMapping("/{id}")
    fun getGetId(@PathVariable id:Long) = promocoes[id]
    
    @PostMapping()
    private fun create(@RequestBody promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }
    @DeleteMapping()
    fun delete(@PathVariable id: Long){
        promocoes.remove(id)
    }
    
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao){
        promocoes.remove(id)
        promocoes[id] = promocao
    }
    @GetMapping()
    fun getAll( @RequestParam (required = false, defaultValue = "") localFilter: String) =""
    
    }
    
    
