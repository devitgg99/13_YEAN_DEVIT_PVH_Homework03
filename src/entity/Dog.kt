package entity

class Dog(name: String) : Animal(name) {
    override fun speak() {
        super.speak()
        if (soundCount % 2 == 1) {
            println("$name says Woof!")
        } else {
            println("$name is silent this time.")
        }
    }
}