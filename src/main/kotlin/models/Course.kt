package models

abstract class Course(var name: String, var price: Float, var Hrduration: Float, var chapters: Int, val author: String, var rating: Float, var topic: String) {
    init {
        println("Se ha añadido un nuevo curso $name con precio $price, duracion ${Hrduration}, $chapters capitulos con autor $author y calificacion $rating")
    }
    var isPlaying = false

    abstract fun updateCourse(name: String, price: Float, duration: Float, chapters: Int, rating: Float)


}