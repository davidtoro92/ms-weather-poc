package cl.dtoros.weather.poc.client

import cl.dtoros.weather.poc.dto.WeatherApiResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import kotlin.collections.LinkedHashMap

@Component
class WeatherRestClient {

    private var logger = LoggerFactory.getLogger(WeatherRestClient::class.java)

    @Value("\${weather.api.host}")
    private lateinit var host: String

    @Value("\${weather.api.key}")
    private lateinit var key: String

    @Value("\${weather.api.url}")
    private lateinit var url: String

    fun consultarClimaPaisCiudad(pais: String, ciudad: String): WeatherApiResponse {
        try {
            logger.info("[WeatherRestClient.consultarClimaPaisCiudad] Inicializando consulta rest-client api weather")

            var restTemplate = RestTemplate()
            var urlFormated = String.format(url, ciudad, pais)
            var headers = configureHeaders()
            var entity = HttpEntity<MultiValueMap<String, String>>(headers)

            val response: ResponseEntity<LinkedHashMap<*, *>>? = restTemplate.exchange(urlFormated,HttpMethod.GET,
                entity, LinkedHashMap::class.java)

            if (response != null) {
                return WeatherApiResponse.weatherMapping(response.body)
            } else {
                return WeatherApiResponse()
            }

        } finally {
            logger.info("[WeatherRestClient.consultarClimaPaisCiudad] Fin consulta rest-client api weather")
        }
    }

    private fun configureHeaders(): HttpHeaders {

        var headers = HttpHeaders()
        headers["x-rapidapi-host"] = host
        headers["x-rapidapi-key"] = key

        return headers
    }

}