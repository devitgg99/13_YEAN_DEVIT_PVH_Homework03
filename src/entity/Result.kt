package entity

sealed class Result {
    data class Success(val value: Any) : Result()
    data class Error(val message: String) : Result()
}

fun processResult(result: Result) {
    when (result) {
        is Result.Success -> println("Success with value: ${result.value}")
        is Result.Error -> println("Error: ${result.message}")
    }
}