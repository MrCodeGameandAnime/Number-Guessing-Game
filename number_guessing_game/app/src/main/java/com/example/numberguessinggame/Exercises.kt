package com.example.numberguessinggame

import android.util.Log
import com.example.numberguessinggame.common.Window
import com.example.numberguessinggame.model.GameUser

// Chapter 2
///////////////////////////////////////////////////////

private var TAG:String = "EXER"
private lateinit var v:Triangle

fun main(args:Array<String>) {
    var gameUser = GameUser("Jack","Black","0983451289",
        4,"03/22/76",60.9) // Exercise 12
    println("onCreate: " + Window.NUMBER_OF_TABS+"\n"+ Window.PREFS_FILE+"\n"+ Window.WINDOW_TITLE) //Exercise 17

    var triangleOne = Triangle(2,2,4) //Exercise 19
    val numberOfCorners = Triangle.NUMBER_OF_CORNERS // Exercise 19

    val collector = Collector()
    val triangle:GraphicsObject = GraphicTriangle()
    collector.add(triangle)

    val aClass = A() // Exercise 2 chapter 3
    aClass.a = 4

    println("1 + 2 = ${1 + 2}")
    val a = 42
    val s = "If we add 4 we get ${a+4}" // Exercise 3 chapter 2

    println(::v.isInitialized)
    val bc = AB()
    // accessing companion object from the class does not need to be instantiated
    println(AB.x(ab=23))
    println(bc.addValues())

    // Exercise 12 chapter 3
    val personTwo = PersonTwo()
    personTwo.setName(fName = "John",lname = "Doe")

    // Exercise 13 chapter 3
    setData(firstName = "George",lastName = "P",birthday = "08/20/20",ssn = "0988768787")
    println(setData(firstName = "George",lastName = "P",birthday = "08/20/20",ssn = "0988768787"))

    val f = func("String","Data")

    val club = Club() // Exercise 14
    club.addMembers("dave","joe","sarah","tina")

    // overridden class parameters inherited from class H to I
    val i = I(23)
    i.x()
    i.y()
}

class Person(val firstName:String,val lastName:String,val ssn:String = " ",val dateOfBirth:String,val gender:Char) {
    var i: Int? = 12
    var s:String = "hello"
    val b:Int = 8
    // Exercise 8,13, and 15
    constructor(firstName: String,lastName: String,ssn: String,gender: Char) :
            this(firstName = firstName,lastName = lastName,ssn = ssn,gender = gender,dateOfBirth = "0000-00-00")
    init {
        i = null
    }
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

    override fun fillColor(): String { return "red" }
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

// Named constructor parameter instantiation is more explicit and readable
val gameUserOne = GameUser(firstName = "Saya",lastName = "Diva",birthday = "200BC",
    userName = "QueenOfTheDamned",registrationNumber = 345,userRank = 5.6)
val gameUserTwo = GameUser(firstName = "Heath",lastName = "Ledger",userName = "TheJoker",registrationNumber = 777)


// Chapter 3
//////////////////////////////////////////////////////////////////

// Exercise 2
class A {
    var a: Int =1
    init {
        a = 2
    }

    fun b() {
        a = 3
    }
}

// One line function
fun add10(int: Int) = int+10
// Implementing "Unit" explicitly declares that the function returns nothing
fun ten(): Unit{}

// function modifiers private,internal,protected,public,open,override,final override,abstract

// Exercise 8
class C(val c:Int) {
    fun add(c:Int): Int = this.c+c
    // Use "this" to access properties instead of parameters where parameters mask properties in functions
    // e.g val c:Int  and c:Int
    fun mult(b:Int):Int = this.c*b
}

// Exercise 9
interface AInterface {
    fun add(b:Int): Int
    fun mult(b:Int): Int
}

class AB {
    val v: Int = 8
    val i: Int = 7
    companion object {
        fun x(ab:Int):Int {return ab+7}
    }

    fun addValues():Int { return v+i}
}

// Exercise 12
class PersonTwo {
    var firstName:String? = null
    var lastName:String? = null
    fun setName(fName:String,lname:String) {
        firstName = fName
        lastName = lname
    }
}

// Exercise 13
fun setData(lastName:String= " ",firstName: String=" ",birthday:String? = " ",ssn:String? = " ") {}

fun moreData():Unit {}

// vararg can take N + x parameters where X is any number from 0 to infinity
fun func(vararg paramV:String) {}

// Exercise 14
class Club{

    fun addMembers(vararg names:String){
        println("Number of names: " + names.size)
        println(names.joinToString(" : "))
    }
}

// Abstract function requires an abstract class and can have no function body, abstract class must
// be inherited
abstract class AbstractClass {
    abstract fun function(vararg data:String)
}

class AbstractClub: AbstractClass() {
    override fun function(vararg data: String) {
    }
}

// Polymorphism allows functions to be named the same and Kotlin discern the difference based on parameter type
class Calculator{
    fun add(a:Int){ }
    fun add(a:Double) { }
    fun add(a:String) { }
}

// Local functions allow having functions inside of functions
fun a() {
    fun b() {
    }
}
// Inheritance requires the class modifier "open"
open class K(dataOne:String,dataTwo: String) {
    constructor() : this(dataOne = " ",dataTwo = " ")

    open fun someData(data:Int):Int {
        return data + 10
    }
} // super class of G
class G: K() {
    override fun someData(data: Int): Int {
        return data + 20
    }
} // subclass of K
class F: K("jim","Bob")

// Exercise 17
// Overriding class parameters
open class H(open val a:Int) {
    // allow properties to be overridden
    open var i:Int = 0
    open fun x() {
        println(TAG+ "H.x() -> a = ${i} ")
    }

    fun q() {
        println(TAG+ "H.q() -> a = $i ")
    }
}
// Exercise 17
// overriding class parameters inherited from class H to I
class I(override val a:Int):H(56) {
    // overriding properties
    override var i: Int = 1
    fun y() {
        println(TAG+ "I.y() -> a = $i ")
        q()
    }
}