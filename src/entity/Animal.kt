package entity

open class Animal(val name: String) {
    var soundCount: Int = 0

    open fun speak() {
        println("$name makes a sound")
        soundCount++
    }
}