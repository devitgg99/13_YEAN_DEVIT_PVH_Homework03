package entity

sealed class Results {
    data class Success(val value: Any) : Results()
    data class Error(val message: String) : Results()
}

fun processResult(result: Results) {
    when (result) {
        is Results.Success -> println("Success with value: ${result.value}")
        is Results.Error -> println("Error: ${result.message}")
    }
}