package com.example.pmacademyandroid_metelov_m23.creational

import android.util.Log

private const val BUILDER_KEY = "BUILDER_KEY"

fun main() {

    val houseBuilder = HouseBuilder()
    houseBuilder.setFloor(42)
    houseBuilder.setSquare(42)
    houseBuilder.setColor("Orange")

    val myHouse = House(houseBuilder)
    Log.d(BUILDER_KEY, myHouse.build())
}

class House(houseBuild: HouseBuilder) {

    private var houseBuilder: HouseBuilder = houseBuild

    fun build(): String {
        return ("This house house has:${houseBuilder.getFloor()} square meters")
    }
}

open class HouseBuilder {
    private var floor: Int? = null
    private var square: Int? = null
    private var color: String? = null

    fun setFloor(Floor: Int) {
        this.floor = Floor
    }

    fun getFloor(): Int? {
        return this.floor
    }

    fun setSquare(square: Int) {
        this.square = square
    }

    fun getSquare(): Int? {
        return this.square
    }

    fun setColor(color: String) {
        this.color = color
    }

    fun getColor(): String? {
        return this.color
    }
}