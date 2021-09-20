package cl.dtoros.weather.poc.dto

class DescripcionApiResponse {

     var id: Int = 0
        get() = field
        set(value) { field = value }
     var main: String = ""
        get() = field
        set(value) { field = value }
     var description: String = ""
        get() = field
        set(value) { field = value }
     var icon: String = ""
        get() = field
        set(value) { field = value }

    constructor()

    constructor(id: Int, main: String, description: String, icon: String) {
        this.id = id
        this.main = main
        this.description = description
        this.icon = icon
    }
}
