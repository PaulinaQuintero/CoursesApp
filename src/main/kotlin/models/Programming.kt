package models

class Programming(name: String, price: Float, Hrduration: Float, chapters: Int, author: String, rating: Float,
                  topic: String, val languaje: String, val framework: String, var IDE: String
) : Course(name, price, Hrduration, chapters, author, rating, topic) {
    override fun updateCourse(name: String, price: Float, duration: Float, chapters: Int, rating: Float) {
        this.name = name
        this.price = price
        this.Hrduration = duration
        this.chapters = chapters
        this.rating = rating
        this.topic = topic
        this.IDE = IDE
    }

    fun getCourseName(): String {
        return this.name
    }
}