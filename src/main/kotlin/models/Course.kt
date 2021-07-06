package models

class Course(var name: String, var price: Float, var Hrduration: Float, var chapters: Int, val author: String, var rating: Float, var topic: String) {
    val commentSection: MutableList<Comment> = mutableListOf()
        get(){
            if(field.size==0){
                println("No hay comentarios para este curso todavía :(")
            }
            return field
        }

    init {
        println("Se ha añadido un nuevo curso $name con precio $price, duracion ${Hrduration}duration, $chapters capitulos con autor $author y calificacion $rating")
    }
    var isPlaying = false
        set(value){
            if(value == false){
                field = true
            } else{
                println("El curso ya se está reproduciendo.")
            }
        }

    fun updateCourse(name: String, price: Float, duration: Float, chapters: Int, rating: Float){
        this.name = name
        this.price = price
        this.Hrduration = duration
        this.chapters = chapters
        this.rating = rating
        this.topic = topic
    }

}