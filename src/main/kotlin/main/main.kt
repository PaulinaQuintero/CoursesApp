package main
import models.Comment
import java.util.*
//import models.Comment
import models.Course
import models.User

fun main() {
    /* Cursos Disponibles */
    val availableCourses: MutableList<Course> =
        mutableListOf(
            Course("Desarrollo móvil para principiantes",299f,
            30.5f,10,"Julio Profe",4.5f, "programacion"),
            Course("Desarrollo Web Avanzado",400f,
                56.15f,45,"Ana Barrera",4.2f, "programacion"),
            Course("Diseño Grafico intermedio",350f,
                84.27f,30,"Horacio Fernández",4.8f, "diseño grafico"))
    /* Usuarios registrados*/
    val registeredUsers: MutableList<User> =
        mutableListOf(User("paulina", "paulina.mucito@gmail.com", "paulina123"))
    /*Comentarios de cursos disponibles*/
    val coursesComments: MutableList<Comment> =
        mutableListOf(Comment("Desarrollo móvil para principiantes",  "paulina", 4.5f,"buen curso"))

    /* Código para el proyecto */
    /* Credenciales para el login */
    val username = "admin"// usuario
    val password = "admin123" //password del usuario
    /* End credenciales para el login */

    /* Datos adicionales del usuario de prueba*/
    val creditCard = "123456789" //número de la tarjeta de crédito
    var totalCD = 1500.01f //fondos de la tarjeta de crédito
    val debitCard = "987456321" //número de la tarjeta de débito
    var totalDC = 2512.30f //fondos de la tarjeta de débito
    /* End Datos adicionales del usuario */

    /* Variables para la ejecución de los while */
    val exit = 0//variable par salir del programa
    var opcionMenu = 0 //variable para escoger la opción del menú de inicio (7 opciones)
    var opcionSalidaMenu = 0 // variable para mostrar o no el menú de inicio aka. salir de la "app".

    /* Estructuras de datos de tipo MAP mutable */
    // Key = usuario : // Value = password
    val usuariosAdmin: MutableMap<String, String> = mutableMapOf("admin1" to "123", "admin2" to "456")

    var currentUser = "Sin identificar"
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
        val usuarioNuevo = readLine().toString()
        println("Ingrese su correo electronico: ")
        val email = readLine().toString()
        println("Ingrese un password (minimo 8 caracteres): ")
        val passwordNuevo = readLine().toString()
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
        val email = readLine().toString()
        println("Password: ")
        val pass = readLine().toString()
        /*Se valida que el usuario exista*/
        val myUser = registeredUsers.find{ it.email == email}
        if(myUser==null){
            println("Usuario no está registrado")
        }else{
            myUser.LogIn(email, pass)
            var currentUser = "Usuario"
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

    fun displayCourses() {
        println("-----------------------------CURSOS DISPONIBLES---------------------------------")
        availableCourses.forEach{
            println(it.name+" "+ " "+it.price+ " "+it.author)
        }
        println("********************************************************************\n")
    }
    fun addCourse() {
        println("-----------------------------AGREGAR CURSO---------------------------------")
        println("Nombre del curso")
        val courseName = readLine().toString()
        println("Costo del curso")
        val courseCost = readLine()?.toFloat()
        println("Duración del curso")
        val courseDuration = readLine()?.toFloat()
        println("Capitulos del curso")
        val courseChapters = readLine()?.toInt()
        println("Autor/es del curso")
        val courseAutor = readLine().toString()
        println("Tematica del curso")
        val courseTopic = readLine().toString()
        availableCourses.add(Course(courseName, courseCost!!,courseDuration!!,courseChapters!!,courseAutor,0f, courseTopic))
        println("\n ¡Curso $courseName añadido correctamente!")
        println("********************************************************************\n")
    }

    fun deleteCourse() {
        println("------------------------------ELIMINAR CURSO---------------------------------")
        println("Estos son los cursos disponibles por el momento:")
        displayCourses()
        println("Nombre del curso que quieres eliminarr")
        val courseName = readLine().toString()
        println("¿Estas seguro que quieres eliminar? S/N")
        val confirmation = readLine().toString().toUpperCase()
        when (confirmation) {
            "S" -> {
                availableCourses.removeAt(
                    availableCourses.indexOf(availableCourses.find{ it.name == courseName}));
                println("\n ¡Curso $courseName eliminado correctamente!")
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

    fun payCourse(){
        println("-----------------------------PAGAR CURSO---------------------------------")
        println("Los cursos que hay disponibles son:")
        displayCourses()
        println("Escribe el nombre del curso que quieres pagar:")
        val courseName = readLine().toString()
        println("¿Qué metodo de pago deseas usar?")
        println("1 = Tarjeta de debito")
        println("2 = Tarjeta de credito")
        val paymentMethod = readLine()?.toInt()
        println("Ingresa el numero de tarjeta")
        val card = readLine().toString()
        if(paymentMethod == 1) {
            if (card == debitCard) {
                if(totalDC > availableCourses.find{ it.name == courseName}?.price!!) {
                    totalDC -= availableCourses.find{ it.name == courseName}?.price!!
                    println("¡Pago aprobado! Has comprado el curso $courseName exitosamente")
                }
                else {
                    println("Saldo insuficiente para terminar la compra")
                }
            }
        } else {
            if (card == creditCard) {
                if(totalCD > availableCourses.find{ it.name == courseName}?.price!!) {
                    totalCD -= availableCourses.find{ it.name == courseName}?.price!!
                    println("¡Pago aprobado! Has comprado el curso $courseName exitosamente")
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
        var courseName = readLine().toString()
        println("Calificacion de 0 a 5")
        var courseRating = readLine()?.toFloat()
        println("Nombre de usuario")
        var userName= readLine().toString()
        println("Comentario del curso")
        var courseComment = readLine().toString()
        coursesComments.add(Comment(courseName, userName, courseRating, courseComment))
        println("********************************************************************\n")
    }
    fun displayUsers(){
        println("-----------------------------VER USUARIOS---------------------------------")
        println("¿Cómo deseas ver los usuarios?")
        println("1 = Ver todos | 2 = Ver solo usuarios con derechos de admin | 3 = Ver usuarios sin derechos de admin")
        val opcion = readLine()?.toFloat()
        when(opcion){
            1f -> {
                registeredUsers.forEach { println(it.name) }
                usuariosAdmin.forEach { println(it.key) }
            }
            2f -> usuariosAdmin.forEach { println(it.key)}
            3f -> registeredUsers.forEach { println(it.name)}
            else->{
                println("Opción no es válida, favor de ingresar una de las opciones disponibles")
                displayUsers()
            }
        }
    }
    fun confirmarSalida(){
        println("¿Desea regresar al menu principal?")
        println("1 = SI | 2 = NO")
        println("Su respuesta: ")
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
                displayCourses()
            }
            4 -> {
                addCourse()
            }
            5 -> {
                deleteCourse()
            }
            6 -> {
                payCourse()
            }
            7 -> {
                addComment()
            }
            8 -> {
                displayUsers()
            }
            else -> {
                println("Esa opción no es válida...")
            }
        }
        confirmarSalida()
        opcionSalidaMenu = readLine()!!.toInt()
    } while (opcionSalidaMenu == 1)// ejecuta el menú principal mientras la opción del usuario sea 1
}


