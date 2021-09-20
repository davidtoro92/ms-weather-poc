package cl.dtoros.weather.poc.dto

class CoordenadasApiResponse {

     var lon: Double = 0.0
        get() = field
        set(value) {
            field = value
        }
     var lat: Double = 0.0
        get() = field
        set(value) {
            field = value
        }

    constructor()

    constructor(lon: Double, lat: Double) {
        this.lon = lon
        this.lat = lat
    }

}