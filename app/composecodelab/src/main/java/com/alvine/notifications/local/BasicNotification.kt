package com.alvine.notifications.local

data class ComposeRandomItem(
    val name: String,
    val schedule: String,
    val type: String,
    val description: String
)

object DataSource {
    val plants = listOf(
        ComposeRandomItem(
        name = "fruits",
        description = "",
        type = "local",
        schedule = ""
    ),
         ComposeRandomItem(
        name = "potatoes",
        description = "",
        type = "local",
        schedule = ""
    ),

        ComposeRandomItem(
        name = "potatoes",
        description = "",
        type = "local",
        schedule = ""
    ),

        ComposeRandomItem(
        name = "potatoes",
        description = "",
        type = "local",
        schedule = ""
    ),


        )
}