package models

class Databases(name: String, price: Float, Hrduration: Float, chapters: Int, author: String, rating: Float,
                topic: String, val isSQL: Boolean, val systemDB: String, var dbManager: String
) : Course(name, price, Hrduration, chapters, author, rating, topic) {
    override fun updateCourse(name: String, price: Float, duration: Float, chapters: Int, rating: Float) {
        this.name = name
        this.price = price
        this.Hrduration = duration
        this.chapters = chapters
        this.rating = rating
        this.topic = topic
        this.dbManager = dbManager
    }
}