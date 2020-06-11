package com.pierre.demo.exception

import com.pierre.demo.model.ErrorMessage
import java.lang.Exception

class PromocaoNotFoundException (message: String) : Exception(message) {
}