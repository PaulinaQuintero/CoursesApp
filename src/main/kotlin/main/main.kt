package main

fun main() {

    /* Cursos Disponibles */
    val courses: MutableMap<String, Float> = mutableMapOf(
        "Desarrollo Movil principiantes" to 500f,
        "Desarrollo Web Avanzado" to 400f,
        "Diseño Grafico intermedio" to 350f,
        "Infraestructura AWS" to 750f,
        "Bases de datos con MySql" to 750f
    )

    /* Código para el proyecto */
    /* Credenciales para el login */
    var username = "admin"// usuario
    var password = "admin123" //password del usuario
    /* End credenciales para el login */


    /* Datos adicionales del usuario */
    var creditCard = "123456789" //número de la tarjeta de crédito
    var totalCD = 1500.01f //fondos de la tarjeta de crédito
    var debitCard = "987456321" //número de la tarjeta de débito
    var totalDC = 2512.30f //fondos de la tarjeta de débito
    /* End Datos adicionales del usuario */


    /* Variables para la ejecución de los while */
    var exit = 0//variable par salir del programa
    var opcionInicio = 0 //variable para escoger la opción de inicio Login|Registrar
    var opcionSalidaInicio = 0 // variable para mostrar o no el menú de inicio

    /* Estructuras de datos de tipo MAP mutable */
    // Key = usuario
    // Value = password
    val usuarios: MutableMap<String, String> = mutableMapOf("admin1" to "123", "admin2" to "456")

    /* Funciones */
    fun saludar(user: String) {
        println("¡Hola $user!")
    }

    fun registrar() {
        println("---------------------------Registro--------------------------------")
        println("Ingrese un usuario: ")
        //nombre = readLine().toString()
        var usuarioNuevo = readLine().toString()
        println("Ingrese un password: ")
        //password = readLine().toString()
        var passwordNuevo = readLine().toString()
        usuarios.put(usuarioNuevo, passwordNuevo)
        println(usuarios)
        println("Usuario registrado correctamente")
    }

    fun login() {
        println("-----------------------------LOGIN---------------------------------")
        // leemos las credenciales del usuario
        println("Usuario: ")
        var user = readLine().toString()
        println("Password: ")
        var pass = readLine().toString()
        // comparamos si el usuario y el password coinciden
        if ((user in usuarios.keys) && (usuarios.get(key = user).equals(pass))) {
            println("Ingreso correcto")
            saludar(user)
            exit = 2
        } else {
            println("Lo sentimos, usuario o password incorrectos, intente de nuevo")
            println("¿Desea intentarlo de nuevo?")
            println("1 = SI | 2 = NO")
            println("Ingrese su respuesta:")
            exit = readLine()!!.toInt()
            if (exit == 2) {
                println("Hasta luego...")
            }
        }
    }

    fun displayCurses() {
        println("-----------------------------CURSOS DISPIBLES---------------------------------")
        courses.forEach{
            println(it)
        }
        println("********************************************************************\n")
    }

    fun addCourse() {
        println("-----------------------------AGREGAR CURSO---------------------------------")
        println("Nombre del curso")
        var courseName = readLine().toString()
        println("Costo del curso")
        var courseCost = readLine()?.toFloat()
        courses.put(courseName, courseCost!!)
        println("\n ¡Curso $courseName añadido correctamente!")
        println("********************************************************************\n")
    }

    fun deleteCourse() {
        println("-----------------------------ELIMINAR CURSO---------------------------------")
        println("Nombre del curso que quieres eliminarr")
        val courseName = readLine().toString()
        println("¿Estas seguro que quieres eliminar? S/N")
        val confirmation = readLine().toString().toUpperCase()
        if (confirmation == "S") {
            courses.remove(courseName);
            println("\n ¡Curso $courseName eliminado correctamente!")
        } else if (confirmation == "N") {
            return
        } else {
            println("Opcion invalida")
            return
        }

        println("********************************************************************\n")
    }

    fun payCourse(){
        println("-----------------------------PAGAR CURSO---------------------------------")
        println("Nombre del curso que quieres pagar")
        val courseName = readLine().toString()
        println("¿Qué metodo de pago deseas usar?")
        println("1 = Tarjeta de debito")
        println("2 = Tarjeta de credito")
        val paymentMethod = readLine()?.toInt()
        println("Ingresa el numero de tarjeta")
        val card = readLine().toString()
        if(paymentMethod == 1) {
            if (card == debitCard) {
                if(totalDC > courses[courseName]!!) {
                    totalDC -= courses[courseName]!!
                    println("¡Pago aprobado! Has comprado el curso $courseName exitosamente")
                }
                else {
                    println("Saldo insuficiente para terminar la compra")
                }
            }
        } else {
            if (card == creditCard) {
                if(totalCD > courses[courseName]!!) {
                    totalCD -= courses[courseName]!!
                    println("¡Pago aprobado! Has comprado el curso $courseName exitosamente")
                }
                else {
                    println("Saldo insuficiente para terminar la compra")
                }
            }
        }
    }

    /* Menú a mostrar al usuario */
    println("-------------------------------------------------------------------")
    println("------------------------------UDEMY--------------------------------")
    println("---------------------------BIENVENIDO------------------------------")
    println("")
    do {
        println("-----------------------Escoja una opción---------------------------")
        println("1: Login")
        println("2: Registrar")
        println("3: Mostrar Cursos")
        println("4: Añadir un nuevo curso")
        println("5: Eliminar un curso")
        println("6: Pagar un curso")
        println("Su opción: ")
        opcionInicio = readLine()!!.toInt()

        when (opcionInicio) {
            1 ->
                do {
                    login()
                } while (exit == 1)//ejecuta el código mientras la respuesta del usuario sea 1

            2 -> {
                registrar()
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
            3 -> {
                displayCurses()
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
            4 -> {
                addCourse()
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
            5 -> {
                deleteCourse()
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
            6 -> {
                payCourse()
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
            else -> {
                println("Esa opción no es válida...")
                println("¿Desea regresar al inicio?")
                println("1 = SI | 2 = NO")
                println("Su respuesta: ")
                opcionSalidaInicio = readLine()!!.toInt()
            }
        }
    } while (opcionSalidaInicio == 1)// ejecuta el menú principal mientras la opción del usuario sea 1

}