package cl.dtoros.weather.poc.service

import cl.dtoros.weather.poc.client.WeatherRestClient
import cl.dtoros.weather.poc.dto.WeatherApiResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WeatherService {

    private var logger = LoggerFactory.getLogger(WeatherService::class.java)

    @Autowired
    private lateinit var weatherRestClient: WeatherRestClient

    fun consultarClimaPaisCiudad(pais: String, ciudad: String): WeatherApiResponse {
        try {
            logger.info("[WeatherService.consultarClimaPaisCiudad] Inicio de consulta de servicio apiweather")
            return weatherRestClient.consultarClimaPaisCiudad(pais, ciudad)
        } finally {
            logger.info("[WeatherService.consultarClimaPaisCiudad] Fin de consulta de servicio apiweather")
        }
    }
}