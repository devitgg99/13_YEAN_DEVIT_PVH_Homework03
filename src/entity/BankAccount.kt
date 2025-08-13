package entity

class BankAccount {
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $amount. New balance: $balance")
        } else {
            println("Invalid deposit amount")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $amount. New balance: $balance")
        } else {
            println("Withdrawal failed: invalid amount")
        }
    }
}