package com.example.practice002.utility.constantData

import com.example.practice002.R


data class filter(val filterName:String, val filterItem: List<String>)

var filters = listOf<filter>(
    filter("Categories", listOf("Eggs","Noodle & Pasta","Chips & Crisps","Fast Food")),
    filter("Brand", listOf("Individual Collection ","Cocola","Ifad","Kazi Farmas"))
)


val profileItems = listOf(
    "Order" to R.drawable.orders_icon,
    "My Detail" to R.drawable.my_details_icon,
    "Delivery Address" to R.drawable.delicery_address,
    "Payment Method" to R.drawable.payment_method,
    "Promo Card" to R.drawable.promo_cord_icon,
    "Notification" to R.drawable.bell_icon,
    "Help" to R.drawable.help_icon,
    "About" to R.drawable.about_icon
)