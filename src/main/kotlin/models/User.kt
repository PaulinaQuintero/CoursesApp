package models


class User(var name: String, var last_name: String, var email: String) {

    val PASSWORD_LENGTH = 8
    init {
        println("¡Usuario $name $last_name registrado exitosamente!")
    }

    var isLogIn = false

    private var password: String = ""
        set(value){
            if(value.length >= PASSWORD_LENGTH){
                field = value
            } else{
                println("La contraseña debe contener al menos 10 caracteres")
            }
        }

    fun updateProfile(name: String, last_name: String, email: String){
        this.name = name
        this.last_name = last_name
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




}