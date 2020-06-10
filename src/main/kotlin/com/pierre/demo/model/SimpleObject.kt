package com.pierre.demo.model

import org.springframework.web.bind.annotation.GetMapping
import java.util.*

class SimpleObject {
    public  val name = "Hello"
    private val zone = "World"
    
    public fun getPlace()= zone
    
}