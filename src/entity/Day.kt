package entity

enum class Day(val isHoliday: Boolean) {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true)
}

fun countHolidays(days: List<Day>): Int {
    return days.count { it.isHoliday }
}