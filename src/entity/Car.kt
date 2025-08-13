package entity

class Car : Vehicle() {
    fun increaseSpeed(amount: Double) {
        if (amount > 0) {
            speed = (speed + amount).coerceAtMost(120.0)
            println("Current speed: $speed")
        } else {
            println("Invalid speed increase")
        }
    }
}