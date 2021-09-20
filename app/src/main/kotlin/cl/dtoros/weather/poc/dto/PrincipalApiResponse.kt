package cl.dtoros.weather.poc.dto

class PrincipalApiResponse {

     var temp: Double = 0.0
        get() = field
        set(value) { field = value }

     var feels_like: Double = 0.0
        get() = field
        set(value) { field = value }

     var temp_min: Double = 0.0
        get() = field
        set(value) { field = value }

     var temp_max: Double = 0.0
        get() = field
        set(value) { field = value }

     var pressure: Int = 0
        get() = field
        set(value) { field = value }

     var humidity: Int = 0
        get() = field
        set(value) { field = value }

    constructor()

    constructor(temp: Double, feels_like: Double, temp_min: Double, temp_max: Double,
                pressure: Int, humidity: Int) {
        this.temp = temp
        this.feels_like = feels_like
        this.temp_min = temp_min
        this.temp_max = temp_max
        this.pressure = pressure
        this.humidity = humidity
    }
}
