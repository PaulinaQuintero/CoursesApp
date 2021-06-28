package models

class Payment(private var user:User,
              private var paymentMethod: String,
              private var cardNumber: String,
              private var totalCard: Float,
              private var holdName: String) {
    init {
        addPaymentMethod(Payment(this.user,this.paymentMethod,this.cardNumber,this.totalCard,this.holdName))
        println("Se creó con éxito el método de pago ${this.paymentMethod}")
    }
    fun addPaymentMethod(paymentMethod:Payment){
        //Se busca que el método de pago y la tarjeta no estén registrados previamente.
        if(paymentMethod !in user.listOfPaymentMethods &&
            user.listOfPaymentMethods.filter{ it.cardNumber == paymentMethod.cardNumber }.isEmpty()){
            user.listOfPaymentMethods.add(paymentMethod)
        }else{
            println("Este método de pago ya estaba agregado")
        }
    }
    fun deletePaymentMethod(paymentMethod: Payment){
        user.listOfPaymentMethods.removeAt(user.listOfPaymentMethods.indexOf(paymentMethod))
    }
}