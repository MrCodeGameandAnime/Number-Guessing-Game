package com.example.numberguessinggame

import android.util.Log
import com.example.numberguessinggame.common.Window
import com.example.numberguessinggame.model.GameUser


fun main() {
    var gameUser = GameUser("Jack","Black","0983451289",
        4,"03/22/76",60.9) // Exercise 12
    println("onCreate: " + Window.NUMBER_OF_TABS+"\n"+ Window.PREFS_FILE+"\n"+ Window.WINDOW_TITLE) //Exercise 17

    var triangleOne = Triangle(2,2,4) //Exercise 19
    val numberOfCorners = Triangle.NUMBER_OF_CORNERS // Exercise 19

    val collector = Collector()
    val triangle:GraphicsObject = GraphicTriangle()
    collector.add(triangle)
}

class Person(val firstName:String,val lastName:String,val ssn:String = " ",val dateOfBirth:String,val gender:Char) {
    // Exercise 8,13, and 15
    constructor(firstName: String,lastName: String,ssn: String,gender: Char) :
            this(firstName = firstName,lastName = lastName,ssn = ssn,gender = gender,dateOfBirth = "0000-00-00")
}

// Exercise 18
class Triangle(firstSideLength:Int,secondSideLength:Int,thirdSideLength:Int) {
    companion object {
        const val NUMBER_OF_CORNERS = 3
    }

    fun info() {
        Log.d("EXER", "info: $NUMBER_OF_CORNERS")
    }
}

class Collector {

    fun add(graphics:GraphicsObject) {
        println("Collector.add()")
        println("Number of corners: "+ graphics.numberOfCorners())

        println("Color: " + graphics.fillColor())
        println("Coordinates of x and y" +graphics.coordsOf(1))
    }
}

class GraphicTriangle: GraphicsObject {
    override fun numberOfCorners(): Int {
        return 3
    }

    override fun coordsOf(index: Int): Pair<Double, Double> {
        return when(index) {
            0 -> Pair(-1.0,0.0)
            1 -> Pair(1.0,0.0)
            2 -> Pair(0.0,1.0)
            else -> throw RuntimeException("Index ${index} out of bounds")
        }
    }

    override fun fillColor(): String {
        return "red"
    }
}

class GraphicTriangleAlt: GraphicsObject {
    override fun numberOfCorners() = 3
    override fun fillColor() = "red"
    override fun coordsOf(index:Int) =
        when(index) {
            0 -> Pair(-1.0,0.0)
            1 -> Pair(1.0,0.0)
            2 -> Pair(0.0,1.0)
            else -> throw RuntimeException(
                "Index ${index} out of bounds")
        }
}

class Electron: ElementaryParticle {
    // Exercise 20
    override fun mass() = 9.11e-31
    override fun charge() = -1.0
    override fun spin() = 0.5
}

class Proton: ElementaryParticle {
    override fun mass(): Double {
        return 1.67e-27
    }

    override fun charge(): Double {
        return 0.5
    }

    override fun spin(): Double {
        return 0.5
    }
}

interface GraphicsObject {
    fun numberOfCorners(): Int
    fun coordsOf(index:Int): Pair<Double,Double>// Represents x and y coordinates of a point
    fun fillColor(): String
}

interface ElementaryParticle {
    // Exercise 20
    fun mass(): Double
    fun charge(): Double
    fun spin(): Double
}

val firstPerson = Person("Jack","Black","0983451289","03/22/76",'M') // Exercise 9
val secondPerson = Person(
    firstName = "Jack",
    lastName = "Black",
    ssn = "0983451289",
    dateOfBirth = "03/22/76",
    gender = 'M') // Exercise 11
val thirdPerson = Person("Tito","Ortiz","00000",'M') // Exercise 15

// Named constructor parameter instantiation is more explicit and human readable
val gameUserOne = GameUser(firstName = "Saya",lastName = "Diva",birthday = "200BC",
    userName = "QueenOfTheDamned",registrationNumber = 345,userRank = 5.6)
val gameUserTwo = GameUser(firstName = "Heath",lastName = "Ledger",userName = "TheJoker",registrationNumber = 777)