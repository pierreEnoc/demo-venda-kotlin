package com.pierre.demo.controller
import com.pierre.demo.exception.PromocaoNotFoundException
import com.pierre.demo.model.ErrorMessage
import com.pierre.demo.model.Promocao
import com.pierre.demo.model.ResponseJSON
import com.pierre.demo.servico.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {
    @Autowired
    lateinit var promocaoService: PromocaoService
    
    @GetMapping("/{id}")
    fun getGetId(@PathVariable id:Long) : ResponseEntity<Any> {
        var promocao = this.promocaoService.getById(id)
           return  if (promocao != null)
               return ResponseEntity(promocao,HttpStatus.OK)
        else
               return ResponseEntity(ErrorMessage("Promocao nao localizada","promocao ${id} nao localizada"),HttpStatus.NOT_FOUND)
        
        return ResponseEntity(promocao, HttpStatus.OK)
    }
    
    @PostMapping()
    private fun create(@RequestBody promocao: Promocao): ResponseEntity<ResponseJSON>{
        this.promocaoService.create(promocao)
        val respostaJSON = ResponseJSON("message", Date())
        return ResponseEntity(respostaJSON, HttpStatus.CREATED)
    }
    @DeleteMapping()
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
       var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getById(id) !=null){
            status = HttpStatus.ACCEPTED
            this.promocaoService.delete(id)
        }
        return ResponseEntity(Unit, status)
    }
    
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
            if(this.promocaoService.getById(id) !== null ){
                this.promocaoService.update(id, promocao)
                status = HttpStatus.ACCEPTED
            }
        return ResponseEntity(Unit, status)
    }
    @GetMapping()
    fun getAll( @RequestParam (required = false, defaultValue = "") localFilter: String):  ResponseEntity<List<Promocao>>{
        var status = HttpStatus.OK
        val listaPromocoes = this.promocaoService.searchByLocal(localFilter)
        if(listaPromocoes.size == 0){
            status = HttpStatus.NOT_FOUND
    }
       return ResponseEntity(listaPromocoes, status)
    }
    
    
    }
    
    
