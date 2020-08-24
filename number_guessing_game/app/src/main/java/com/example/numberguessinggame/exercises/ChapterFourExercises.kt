package com.example.numberguessinggame.exercises

import java.lang.Math.log

// Chapter 4
/////////////////////////////////////////////////////////

fun main(args:Array<String>) {
    val inst_one:SomeInterface = AClass()
    val inst_two:SomeInterface = BClass()

    // Anonymous classes
    val inst_three:SomeInterface = object : SomeInterface {
        override fun addData(i: Int) {
            val x:String = " "
            if (i >= 100) {
                println(x + i)
            } else if (i >= 50) {
                println(x + i)
            } else if (i >= 25){
                println(x + i)
            }
        }
    }

    val inst_four:BClass = object : BClass() {
        override fun addData(i: Int) {
            i + 10
        }
    }
    // accessing inner class
    val abc = ABC.DEF()
    val abc_two = ABC().method()

    // data class usage
    val pt = Point(0.0,1.0)
    val pt2 = movePoint(pt,0.5,0.5)
}

interface SomeInterface {
    fun addData(i:Int)
}

interface X {
    fun doSomething()
}

class AClass:SomeInterface {
    override fun addData(i: Int) {
    }

    fun method() {
        val x = object : X {
            override fun doSomething() {
                println(this)
                println(this@AClass)
            }
        }
    }
}

open class BClass: SomeInterface {
    override fun addData(i: Int) {
        TODO("Not yet implemented")
    }
}

class ABC {
    // inner classes
    class DEF {  }
    fun method() {
        // only accessible within the method
        class GHI {  }
    }
}

// Importing function and properties
class AC {
    fun calc(a:Double) = Math.log(a)
}

class CA {
    fun calc(a:Double) = log(a)
}

// Data classes have no or little functions and are a collection of properties. Great for for a
// function that returns structured or compound data such as a model of real life constructs
data class Point(val x:Double, val y:Double)
fun movePoint(pt:Point,dx:Double,dy:Double):Point = Point(pt.x + dx,pt.y + dy)