package cl.dtoros.weather.poc.exception

class ErrorMessage {

    var codigoError: Int = 0
        get() = field
        set(value) { field = value }
    var mensaje: String = ""
        get() = field
        set(value) { field = value }

    var descripcion: String = ""
        get() = field
        set(value) { field = value }

    constructor()

    constructor(codigoError: Int, mensaje: String, descripcion: String) {
        this.codigoError = codigoError
        this.mensaje = mensaje
        this.descripcion = descripcion
    }
}