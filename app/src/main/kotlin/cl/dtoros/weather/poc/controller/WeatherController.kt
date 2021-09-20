package cl.dtoros.weather.poc.controller

import cl.dtoros.weather.poc.dto.WeatherApiResponse
import cl.dtoros.weather.poc.service.WeatherService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("weather-service")
@RestController
class WeatherController {

    @Autowired
    private lateinit var weatherService: WeatherService

    //Inicializa logger de clase
    private val logger = LoggerFactory.getLogger(WeatherController::class.java)

    @GetMapping("/current-weather/{pais}/{ciudad}")
    fun consultarClimaPaisCiudad(@PathVariable("pais") pais: String
                       , @PathVariable("ciudad") ciudad: String): ResponseEntity<WeatherApiResponse> {
        try {
            logger.info("[WeatherController.consultarClima] Inicio de metodo")
            var entity: WeatherApiResponse = weatherService.consultarClimaPaisCiudad(pais, ciudad)
            return ResponseEntity.ok(entity)
        } finally {
            logger.info("[WeatherController.consultarClima] Fin de metodo")
        }
    }
}