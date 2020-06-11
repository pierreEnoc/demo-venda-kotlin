package com.pierre.demo.advice

import com.pierre.demo.exception.PromocaoNotFoundException
import com.pierre.demo.model.ErrorMessage
import org.springframework.boot.json.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest, servletRespons: HttpServletResponse, exception: Exception):
            ResponseEntity<ErrorMessage> {
            return ResponseEntity(ErrorMessage("JSON ERROR", exception.message ?:"Invalid Json"),HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(PromocaoNotFoundException::class)
    fun PromocaoNotFoundExceptionHandler(servletRequest: HttpServletRequest, servletRespons: HttpServletResponse,
                                         exception: Exception): ResponseEntity<ErrorMessage>{
        return ResponseEntity(ErrorMessage("Promocao nao localizada", exception.message !!),HttpStatus.NOT_FOUND)
        
    }
}