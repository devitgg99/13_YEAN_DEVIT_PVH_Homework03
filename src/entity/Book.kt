package entity

class Book(var title:String, var author:String, var age:Int){
    init {
        if (title.isEmpty() || author.isEmpty()){
            println("Title and Author cannot empty")
        }
        if(age <= 0){
            println("Age is greater or equal to 0")
        }
        if(title.isNotEmpty() && author.isNotEmpty() && age > 0){
            println("Book Title: $title")
            println("Author: $author")
            println("Age: $age")
        }
    }
}