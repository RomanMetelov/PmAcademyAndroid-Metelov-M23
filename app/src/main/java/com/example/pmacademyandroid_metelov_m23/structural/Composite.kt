package com.example.pmacademyandroid_metelov_m23.structural

import android.util.Log

private const val COMPOSITE_KEY = "COMPOSITE_KEY"

fun main() {
    val menuItems = mutableListOf<MenuItem>()

    val burger = Meal(100.0).apply { setName("Burger") }
    val fries = Meal(50.0).apply { setName("Fries") }
    val pizza = Meal(200.0).apply { setName("Pizza") }
    val burgerCombo = CompoMeal().apply { setName("Burger combo meal") }
    val awesomeCombo = CompoMeal().apply { setName("Awesome combo meal") }

    burgerCombo.apply {
        addItem(burger)
        addItem(fries)
    }

    awesomeCombo.apply {
        addItem(burgerCombo)
        addItem(pizza)
    }

    menuItems.addAll(listOf(burger, pizza, burgerCombo, awesomeCombo))

    menuItems.forEach {
        it.printItem()
    }
}


//The Base Component (Component) - defines the common operations of primitive and composite objects
interface MenuItem {
    fun setName(itemName: String)
    fun getPrice(): Double
    fun printItem()
}

//leaf – implements the default behavior of the base component
class Meal(private val mealPrice: Double) : MenuItem {
    private var mealName: String = ""

    override fun setName(itemName: String) {
        mealName = itemName
    }

    override fun getPrice(): Double {
        return mealPrice
    }

    override fun printItem() {
        Log.d(COMPOSITE_KEY, "$mealName - $mealPrice")
    }
}

//composite – has leaf elements. It implements the base component methods and defines the child-related operations
class CompoMeal : MenuItem {
    private var mealName = ""
    private val items = mutableListOf<MenuItem>()

    fun addItem(menuItem: MenuItem) {
        items.add(menuItem)
    }

    fun removeItem(menuItem: MenuItem) {
        items.remove(menuItem)
    }

    override fun setName(itemName: String) {
        mealName = itemName
    }

    override fun getPrice(): Double {
        var total = 0.0
        items.forEach {
            total += it.getPrice()
        }
        return total
    }

    override fun printItem() {
        Log.d(COMPOSITE_KEY, "$mealName - ${getPrice()}")
    }
}

