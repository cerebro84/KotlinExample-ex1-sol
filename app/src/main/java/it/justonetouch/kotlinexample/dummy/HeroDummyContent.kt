package it.justonetouch.kotlinexample.dummy

object HeroDummyContent {
    private val MALE = "Male"
    private val FEMALE = "Female"

    val ITEMS = arrayListOf  (
            HeroItem("Hulk", MALE, 9, null, "green"),
            HeroItem("Iron Man", MALE, 8, "dark", "brown"),
            HeroItem("Thor", MALE, 8, "blonde", "blue"),
            HeroItem("Jessica Jones", FEMALE, 2, "dark", "brown"),
            HeroItem("Spiderman", MALE, 4, "dark", null)
    )
}
