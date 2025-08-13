package entity

class Employee: Person() {
    override fun introduce() {
        println("Hi my name is $name")
    }
}