package models

class Course(var name: String, var price: Float, var duration: Float, var chapters: Int, val author: String, var rating: Float) {
    init {
        println("Has añadido un nuevo curso $name con precio $price, duracion $duration, $chapters capitulos con autor $author y calificacion $rating")
    }

    var isPlaying = false

    fun updateCourse(name: String, price: Float, duration: Float, chapters: Int, rating: Float){
        this.name = name
        this.price = price
        this.duration = duration
        this.chapters = chapters
        this.rating = rating
    }




}