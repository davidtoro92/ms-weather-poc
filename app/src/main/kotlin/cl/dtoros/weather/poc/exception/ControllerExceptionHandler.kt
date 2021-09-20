package cl.dtoros.weather.poc.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(value = [WeatherMappingException::class])
    fun handlerWeatherMappingException(ex: WeatherMappingException, request: WebRequest): ResponseEntity<*> {
        return errorInterno()
    }

    @ExceptionHandler(value = [HttpClientErrorException::class])
    fun handlerErrorClienteHttp(ex: HttpClientErrorException, request: WebRequest): ResponseEntity<*> {
        when(ex.statusCode.value()) {
            HttpStatus.NOT_FOUND.value() -> return ResponseEntity(ErrorMessage(HttpStatus.NOT_FOUND.value(),
                "Por acá no está lo que buscas :(", "Pronostico no encontrado, " +
                        "intenta consultar por otra ciudad/país :D"), HttpStatus.NOT_FOUND)
            else -> return errorInterno()
        }
    }

    private fun errorInterno(): ResponseEntity<*> {
        return ResponseEntity(ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Por ahora no podemos responder a tu solicitud :(", "Intenta consultar " +
                    "nuevamente más adelante."), HttpStatus.INTERNAL_SERVER_ERROR)
    }

}