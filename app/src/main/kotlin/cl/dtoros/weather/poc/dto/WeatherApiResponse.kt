package cl.dtoros.weather.poc.dto

class WeatherApiResponse {

    var coord: CoordenadasApiResponse = CoordenadasApiResponse()
        get() = field
        set(value) { field = value }

    var weather: DescripcionApiResponse = DescripcionApiResponse()
        get() = field
        set(value) { field = value }

    var main: PrincipalApiResponse = PrincipalApiResponse()
        get() = field
        set(value) { field = value }

    constructor()

    constructor(coord : CoordenadasApiResponse, weather : DescripcionApiResponse, main: PrincipalApiResponse) {
        this.coord = coord
        this.weather = weather
        this.main = main
    }

    companion object {
        fun weatherMapping(body: LinkedHashMap<*, *>?): WeatherApiResponse {
            if(body != null) {
                /*Mapeo de Coordenadas*/
                var coordMap = body.get("coord") as LinkedHashMap<*,*>
                var coord = CoordenadasApiResponse(coordMap.get("lon") as Double, coordMap.get("lat") as Double)

                /*Mapeo de clima*/
                var weatherMap = (body.get("weather") as ArrayList<*>).get(0) as LinkedHashMap<*,*>
                var weather = DescripcionApiResponse(weatherMap.get("id") as Int, weatherMap.get("main") as String,
                    weatherMap.get("description") as String, weatherMap.get("icon") as String)

                /*Mapeo de pronostico meteorologico*/
                var mainMap = body.get("main") as LinkedHashMap<*,*>
                var main = PrincipalApiResponse(mainMap.get("temp") as Double, mainMap.get("feels_like") as Double,
                    mainMap.get("temp_min") as Double, mainMap.get("temp_max") as Double,
                    mainMap.get("pressure") as Int, mainMap.get("humidity") as Int)
                return WeatherApiResponse(coord, weather, main)
            } else {
                //TODO
                return WeatherApiResponse()
            }
        }
    }
}