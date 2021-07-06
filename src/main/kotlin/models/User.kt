package models


class User(var name: String, var email: String, private val pass: String) {
    var userType:String = "user"
    set(value){
        if(value=="admin"){
            field = value
            println("Usuario actualizado con derechos de administrador")
        }
    }

    val PASSWORD_LENGTH = 8
    init {
        println("¡Usuario $name registrado exitosamente!")
    }

    var isLogIn = false

    private var password: String = pass
        set(value){
            if(value.length >= PASSWORD_LENGTH){
                field = value
            } else{
                println("La contraseña debe contener al menos 10 caracteres")
            }
        }

    fun updateProfile(name: String, last_name: String, email: String){
        this.name = name
        this.email = email
    }

    fun LogIn(email: String, password: String){
        if(this.email == email && this.password == password) {
            println("¡Bienvenido ${this.name}!")
            isLogIn = true
        }
        else{
            println("Usuario y contraseña no coinciden intenta de nuevo")
        }
    }
    val listOfPaymentMethods: MutableList<Payment> = mutableListOf()
    fun addPaymentMethod(){
        println("¿Cual es el método de pago que quieres agregar (tarjeta de crédito o débito?")
        val metodo:String = readLine().toString()!!
        println("¿Cual es el número de la tarjeta de ${metodo}?")
        val numTarjeta:String = readLine().toString()!!
        println("¿Cuánto dinero tiene la tarjeta a registrar?")
        val dineroCuenta:Float = readLine()?.toFloat()!!
        println("¿A qué nombre está la tarjeta?")
        val ownerTarjeta:String = readLine().toString()!!
        var newPayment = Payment(this,metodo,numTarjeta,dineroCuenta,ownerTarjeta)
    }

}