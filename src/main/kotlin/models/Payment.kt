package models

class Payment(var paymentMethod: String, var cardNumber: String, var totalCard: Float, var holdName: String) {
    init {
        println("Tarjeta $holdName añadida correctamente ")
    }
}