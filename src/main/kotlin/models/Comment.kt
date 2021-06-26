package models

class Comment(var courseName: String, var courseRating: Float?, var userName: String, var courseComment: String) {
    init {
        println("¡${userName} has añadido un nuevo comentario del curso $courseName correctamente!")
    }
}