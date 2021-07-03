package main

import models.*

fun main() {
    /* Cursos Disponibles */

    val categories: MutableMap<Int, String> = mutableMapOf(1 to "programacion", 2 to "base de datos")
    var shoppingCart = arrayListOf<Course>()
    val availableProgrammingCourses: MutableList<Programming> =
        mutableListOf(
            Programming("Desarrollo móvil para principiantes",299f,
            30.5f,10,"Julio Profe",4.5f, "programacion", "java", "xamarin", "IntelliJ"),
            Programming("Desarrollo Web Full Sack",450f,
                42.9f,12,"John Doe",3.2f, "programacion", "javascript", "react", "Visual Studio Code"),
            Programming("Desarrollo Web Backend",350f,
            50.5f,20,"Hugo Lopez",4.4f, "programacion", "python", "django", "PyCharm"))

    val availableDatabaseCourses: MutableList<Databases> =
        mutableListOf(
            Databases("Mysql de basico a avanzado",200f,
                43.5f,15,"Antonio Morán",2.3f, "base de datos", true, "Mysql", "Workbench"),
            Databases("MongoDb principios basicos",520f,
                60.2f,20,"Juana Castillo",4.9f, "base de datos", false, "MongoDB", "Mongo Atlas"))
    /* Usuarios registrados*/
    val registeredUsers: MutableList<User> =
        mutableListOf(User("paulina", "paulina.mucito@gmail.com", "paulina123"))
    /*Comentarios de cursos disponibles*/
    val coursesComments: MutableList<Comment> =
        mutableListOf(Comment("Desarrollo móvil para principiantes", 4.5f, "paulina", "buen curso"))

    /* Código para el proyecto */
    /* Credenciales para el login */
    var username = "admin"// usuario
    var password = "admin123" //password del usuario
    /* End credenciales para el login */

    /* Datos adicionales del usuario de prueba*/
    var creditCard = "123456789" //número de la tarjeta de crédito
    var totalCD = 1500.01f //fondos de la tarjeta de crédito
    var debitCard = "987456321" //número de la tarjeta de débito
    var totalDC = 2512.30f //fondos de la tarjeta de débito
    /* End Datos adicionales del usuario */

    var totalAmount = 0f

    /* Variables para la ejecución de los while */
    var exit = 0//variable par salir del programa
    var opcionMenu = 0 //variable para escoger la opción del menú de inicio (7 opciones)
    var opcionSalidaMenu = 0 // variable para mostrar o no el menú de inicio aka. salir de la "app".

    /* Estructuras de datos de tipo MAP mutable */
    // Key = usuario : // Value = password
    val usuariosAdmin: MutableMap<String, String> = mutableMapOf("admin1" to "123", "admin2" to "456")

    /* Funciones */
    fun saludar(user: String) {
        println("¡Hola $user!")
    }


    fun registrar() {
        fun retryRegistro(){
            println("¿Desea reintentar el registro?")
            println("1 = SI | 2 = NO")
            println("Su respuesta:")
            val resp = readLine()!!.toInt()
            if(resp==1){
                registrar()
            }
        }

        println("---------------------------Registro--------------------------------")
        println("Ingrese un nombre de usuario: ")
        var usuarioNuevo = readLine().toString()
        println("Ingrese su correo electronico: ")
        var email = readLine().toString()
        println("Ingrese un password (minimo 8 caracteres): ")
        var passwordNuevo = readLine().toString()
        if(email.contains("@") && passwordNuevo.length>=8 &&
            registeredUsers.find{ it.email == email}==null){
            val myUser = User(usuarioNuevo, email, passwordNuevo)
            registeredUsers.add(myUser)
        }else if(email.contains("@")){
            println("La contraseña debe ser mayor a 8 caracteres")
            retryRegistro()
        }else {
            println("Direccion de correo electronico no valida")
            retryRegistro()
        }
    }

    fun login() {
        println("-----------------------------LOGIN---------------------------------")
        // leemos las credenciales del usuario
        println("Usuario: ")
        var email = readLine().toString()
        println("Password: ")
        var pass = readLine().toString()
        /*Se valida que el usuario exista*/
        var myUser = registeredUsers.find{ it.email == email}
        if(myUser==null){
            println("Usuario no está registrado")
        }else{
            myUser.LogIn(email, pass)
        }

        // comparamos si el usuario y el password coinciden
//        if ((user in usuarios.keys) && (usuarios.get(key = user).equals(pass))) {
//            println("Ingreso correcto")
//            saludar(user)
//            exit = 2
//        } else {
//            println("Lo sentimos, usuario o password incorrectos, intente de nuevo")
//            println("¿Desea intentarlo de nuevo?")
//            println("1 = SI | 2 = NO")
//            println("Ingrese su respuesta:")
//            exit = readLine()!!.toInt()
//            if (exit == 2) {
//                println("Hasta luego...")
//            }
//        }
    }

    fun displayCurses() {
        println("-----------------------------CATEGORIAS DISPONIBLES---------------------------------")
        for ((key, value) in categories) {
            print("$key. ${value.substring(0, 1).toUpperCase() + value.substring(1)}\n")
        }
        println("¿De qué categoria deseas explorar?")
        when (val courseTopic = readLine()?.toInt()) {
            1 -> {
                println("-----------------------------CURSOS DISPONIBLES DE ${categories[courseTopic].toString().toUpperCase()}---------------------------------")
                availableProgrammingCourses.forEach{
                    println("Curso: ${it.name}\n Precio: $${it.price}\n Autor: ${it.author}\n Lenguaje: ${it.languaje}\n Framework: ${it.framework}\n")
                    println("********************************************************************\n")
                }
            }

            2 -> {
                println("-----------------------------CURSOS DISPONIBLES DE ${categories[courseTopic].toString().toUpperCase()}---------------------------------")
                availableDatabaseCourses.forEach{
                    println("Curso: ${it.name}\n Precio: $${it.price}\n Autor: ${it.author}\n Sistema de BD: ${it.systemDB}\n")
                    println("********************************************************************\n")
                }
            }
            else -> {
                println("Esa opción no es válida...")
            }
        }
    }
    fun addCourse() {
        println("-----------------------------AGREGAR CURSO---------------------------------")
        println("Nombre del curso")
        val courseName = readLine().toString()
        println("Costo del curso")
        val courseCost = readLine()?.toFloat()
        println("Duración del curso (especifique en horas)")
        val courseDuration = readLine()?.toFloat()
        println("Capitulos del curso")
        val courseChapters = readLine()?.toInt()
        println("Autor/es del curso")
        val courseAutor = readLine().toString()
        println("Agrega una tematica a tu curso, estas son las categorias disponibles")
        for ((key, value) in categories) {
            print("$key. ${value.substring(0, 1).toUpperCase() + value.substring(1)}\n")
        }
        println("Elige una categoria")

        when (val courseTopic = readLine()?.toInt()) {
            1 -> {
                println("Ingresa el lenguaje de programacion del curso")
                val courseLanguage = readLine().toString()
                println("Ingresa el framework del curso")
                val courseFramework = readLine().toString()
                println("Ingresa el IDE que se está usando en el curso")
                val courseIDE = readLine().toString()
                val category = categories[courseTopic].toString()
                availableProgrammingCourses.add(Programming(courseName, courseCost!!,courseDuration!!,courseChapters!!,courseAutor,0f, category, courseLanguage, courseFramework, courseIDE))
            }

            2 -> {
                println("Tu curso es de bases de datos SQL o NoSql?")
                println("1. SQL")
                println("2. NoSql")

                val courseDBType = readLine()?.toInt() == 1
                println("Ingresa el sistema de base de datos")
                val courseDBSystem = readLine().toString()
                println("Ingresa el gestor de BD que se utilizará durante el curso")
                val courseDBManager = readLine().toString()
                val category = categories[courseTopic].toString()
                availableDatabaseCourses.add(Databases(courseName, courseCost!!,courseDuration!!,courseChapters!!,courseAutor,0f, category, courseDBType, courseDBSystem, courseDBManager))
            }
            else -> {
                println("Esa opción no es válida...")
            }
        }
        println("\n ¡Curso $courseName añadido correctamente!")
        println("********************************************************************\n")
    }

    fun deleteCourse() {
        println("-----------------------------ELIMINAR CURSO---------------------------------")
        println("Estos son los cursos disponibles por el momento:")
        displayCurses()
        println("¿Estas seguro que quieres eliminar? Este curso no se podrá recuperar despues S/N")
        val confirmation = readLine().toString().toUpperCase()
        when (confirmation) {
            "S" -> {
                for ((key, value) in categories) {
                    print("$key. ${value.substring(0, 1).toUpperCase() + value.substring(1)}\n")
                }
                println("Elige una categoria")
                when (val courseTopic = readLine()?.toInt()) {
                    1 -> {
                        println("Nombre del curso que quieres eliminarr")
                        val courseName = readLine().toString()
                        availableProgrammingCourses.removeAt(availableProgrammingCourses.indexOf(availableProgrammingCourses.find{ it.name == courseName}));
                        println("\n ¡Curso $courseName eliminado correctamente!")
                    }

                    2 -> {
                        println("Nombre del curso que quieres eliminarr")
                        val courseName = readLine().toString()
                        availableDatabaseCourses.removeAt(availableDatabaseCourses.indexOf(availableDatabaseCourses.find{ it.name == courseName}));
                        println("\n ¡Curso $courseName eliminado correctamente!")
                    }
                    else -> {
                        println("Esa opción no es válida...")
                    }
                }
            }
            "N" -> {
                return
            }
            else -> {
                println("Opcion invalida")
                return
            }
        }
        println("********************************************************************\n")
    }

    fun payShoppingCart(){
        println("-----------------------------PAGAR CARRITO---------------------------------")
        println("¿Qué metodo de pago deseas usar?")
        println("1 = Tarjeta de debito")
        println("2 = Tarjeta de credito")
        val paymentMethod = readLine()?.toInt()
        println("Ingresa el numero de tarjeta")
        val card = readLine().toString()
        val paidCourses = mutableListOf<String>()
        shoppingCart.forEach{
            paidCourses.add(it.name)
        }
        if(paymentMethod == 1) {
            if (card == debitCard) {
                if(totalDC > totalAmount) {
                    totalDC -= totalAmount
                    println("¡Pago aprobado! Has comprado el curso ${paidCourses.joinToString(",")} exitosamente")
                }
                else {
                    println("Saldo insuficiente para terminar la compra")
                }
            }
        } else {
            if (card == creditCard) {
                if(totalCD > totalAmount) {
                    totalCD -= totalAmount
                    println("¡Pago aprobado! Has comprado el curso ${paidCourses.joinToString(",")} exitosamente")
                }
                else {
                    println("Saldo insuficiente para terminar la compra")
                }
            }
        }
    }

    fun addComment() {
        println("-----------------------------AGREGAR COMENTARIO---------------------------------")
        println("Nombre del curso que quieres comentar")
        val courseName = readLine().toString()
        println("Calificacion de 0 a 5")
        val courseRating = readLine()?.toFloat()
        println("Nombre de usuario")
        val userName= readLine().toString()
        println("Comentario del curso")
        val courseComment = readLine().toString()
        coursesComments.add(Comment(courseName, courseRating, userName, courseComment))
        println("********************************************************************\n")
    }
    fun confirmarSalida(){
        println("¿Desea regresar al menu principal?")
        println("1 = SI | 2 = NO")
        println("Su respuesta: ")
    }

    fun addCourseToShoppingCart() {
        println("-----------------------------AGREGAR CURSO AL CARRITO---------------------------------")
        println("Nombre de la categoria del curso que quieres agregar al carrito")
        for ((key, value) in categories) {
            print("$key. ${value.substring(0, 1).toUpperCase() + value.substring(1)}\n")
        }
        when (val courseTopic = readLine()?.toInt()) {
            1 -> {
                println("Nombre del curso que quieres agregar al carrito")
                val courseName = readLine().toString()
                val newCourse = availableProgrammingCourses.find{ it.name==courseName }
                if (newCourse != null) {
                    shoppingCart.add(Programming(newCourse.name, newCourse.price, newCourse.Hrduration, newCourse.chapters, newCourse.author, newCourse.rating, newCourse.topic, newCourse.languaje, newCourse.framework, newCourse.IDE))
                }
                }

            2 -> {
            println("Nombre del curso que quieres agregar al carrito")
            val courseName = readLine().toString()
                val newCourse = availableDatabaseCourses.find{ it.name==courseName }
                if (newCourse != null) {
                    shoppingCart.add(Databases(newCourse.name, newCourse.price, newCourse.Hrduration, newCourse.chapters, newCourse.author, newCourse.rating, newCourse.topic, newCourse.isSQL, newCourse.systemDB, newCourse.dbManager))
                }

            }
            else -> {
                println("Esa opción no es válida...")
            }
        }

    }

    fun showShoppingCart(){
        println("-----------------------------ALMACENADO HASTA EL MOMENTO EN EL CARRITO---------------------------------")
        shoppingCart.forEach{
            totalAmount += it.price
            println("Curso: ${it.name}\n Precio: $${it.price}\n Autor: ${it.author}\n")
            println("********************************************************************\n")
        }
        println("***************************Total a Pagar**************************************")
        println("$totalAmount")
        println("********************************************************************\n")
    }
    /* Menú a mostrar al usuario */
    println("-------------------------------------------------------------------")
    println("------------------------------UDEMY--------------------------------")
    println("---------------------------BIENVENIDO------------------------------")
    println("")
    do {
        println("-----------------------Menú principal---------------------------")
        println("--------------------Por favor elige una opción------------------")
        println("1: Login")
        println("2: Registrar")
        println("3: Mostrar Cursos")
        println("4: Añadir un nuevo curso")
        println("5: Eliminar un curso")
        println("6: Pagar un curso")
        println("7: Añadir comentario de curso")
        println("8: Añadir un curso al carrito")
        println("9: Mostrar carrito")
        println("10: Salir")
        println("Su opción: ")
        opcionMenu = readLine()!!.toInt()

        when (opcionMenu) {
            1 ->
                do {
                    login()
                } while (exit == 1)//ejecuta el código mientras la respuesta del usuario sea 1

            2 -> {
                registrar()
            }
            3 -> {
                displayCurses()
            }
            4 -> {
                addCourse()
            }
            5 -> {
                deleteCourse()
            }
            6 -> {
                payShoppingCart()
            }
            7 -> {
                addComment()
            }
            8 -> {
                addCourseToShoppingCart()
            }
            9 -> {
                showShoppingCart()
            }
            10 -> {
                println("\n*******************************************")
                println("¡Gracias por usar Udemy App, vuelva pronto!")
                println("*******************************************\n")
                return
            }
            else -> {
                println("Ups, esa opción no es válida...")
            }
        }
        confirmarSalida()
        opcionSalidaMenu = readLine()!!.toInt()
    } while (opcionSalidaMenu == 1)// ejecuta el menú principal mientras la opción del usuario sea 1
}


