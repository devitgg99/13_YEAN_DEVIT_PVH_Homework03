import entity.Animal
import entity.BankAccount
import entity.Book
import entity.Car
import entity.Day
import entity.Dog
import entity.Employee
import entity.Person
import entity.Product
import entity.Student
import entity.countHolidays
import entity.processResult

fun main(){
    //OOP Overview
    println(Person().name)
    println()
    Employee().introduce()
    println()

    //Kotlin Class/Object
    Book("a", "a", 1)
    println()

    //Getter and Setter
    Student(10)
    println()

    //Kotlin Data Class
    val product = Product(1,10.5)
    val (id, price) = product
    println("Product ID: $id")
    println("Product Price: $price")

    val copyProduct = product.copy(2,9.5)
    println("Original Product ${product}")
    println("Copy Product ${copyProduct}")

    // Kotlin Sealed Classes
//    val success = Result.success(42)
//    val error = Result.Error("Something went wrong")
//    processResult(success)
//    processResult(error)

    // Enum Classes
    val days = listOf(Day.MONDAY, Day.SATURDAY, Day.SUNDAY, Day.WEDNESDAY)
    println("Number of holidays: ${countHolidays( days)}")
    println()

    // Visibility Modifiers
    val account = BankAccount()
    account.deposit(100.0)
    account.withdraw(50.0)
    account.withdraw(100.0)
    println()

    val car = Car()
    car.increaseSpeed(50.0)
    car.increaseSpeed(80.0)
    car.increaseSpeed(-10.0)
    println()

    // Inheritance
    val animals = listOf(Animal("Lion"), Dog("Rex"))
    animals.forEach { animal ->
        repeat(2) { animal.speak() }
        println("Name: ${animal.name}, Type: ${animal::class.simpleName}, SoundCount: ${animal.soundCount}")
        if (animal is Dog) {
            println("This animal is a dog")
        }
        println()
    }

}