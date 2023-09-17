package life.majd.nour.web

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException

@ControllerAdvice
class ExceptionHandlingController {

    @ExceptionHandler
    fun handleIllegalStateException(ex: HttpClientErrorException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            ex.statusCode.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, ex.statusCode)
    }
}

class ErrorMessageModel(
    var status: Int? = null,
    var message: String? = null
)