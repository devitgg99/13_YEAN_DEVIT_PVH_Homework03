package com.example.practice002.utility.constantData


data class filter(val filterName:String, val filterItem: List<String>)

var filters = listOf<filter>(
    filter("Categories", listOf("Eggs","Noodle & Pasta","Chips & Crisps","Fast Food")),
    filter("Brand", listOf("Individual Collection ","Cocola","Ifad","Kazi Farmas"))
)