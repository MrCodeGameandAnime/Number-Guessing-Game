package com.example.numberguessinggame

import android.util.Log


fun main() {
    var gameUser = GameUser("Jack","Black","0983451289",
        4,"03/22/76",60.9) // Exercise 12
    Log.d("CONST", "onCreate: " +Window.NUMBER_OF_TABS+"\n"+Window.PREFS_FILE+"\n"+Window.WINDOW_TITLE) //Exercise 17

    var triangleOne = Triangle(2,2,4) //Exercise 19
    val numberOfCorners = Triangle.NUMBER_OF_CORNERS // Exercise 19
}

class Person(val firstName:String,val lastName:String,val ssn:String = " ",val dateOfBirth:String,val gender:Char) {
    // Exercise 8,13, and 15
    constructor(firstName: String,lastName: String,ssn: String,gender: Char) :
            this(firstName = firstName,
                lastName = lastName,
                ssn = ssn,
                gender = gender,
                dateOfBirth = "0000-00-00")

}
class GameUser(val firstName:String,
               val lastName:String,
               val userName:String,
               val registrationNumber:Int,
               val birthday:String = "1910-06-07", // Exercise 10 and Exercise 14
               val userRank:Double = 0.0) {
    // Secondary constructor
    constructor(firstName: String,lastName: String,userName: String,registrationNumber: Int) :
            this(firstName = firstName,
                lastName = lastName,
                userName = userName,
                registrationNumber = registrationNumber,
                birthday = "",
                userRank = 0.0)
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

val firstPerson = Person("Jack","Black","0983451289","03/22/76",'M') // Exercise 9
val secondPerson = Person(
    firstName = "Jack",
    lastName = "Black",
    ssn = "0983451289",
    dateOfBirth = "03/22/76",
    gender = 'M') // Exercise 11
val thirdPerson = Person("Tito","Ortiz","00000",'M') // Exercise 15

val gameUserOne = GameUser(
    // Named constructor parameter instantiation is more explicit and human readable
    firstName = "Saya",
    lastName = "Diva",
    birthday = "200BC",
    userName = "QueenOfTheDamned",
    registrationNumber = 345,
    userRank = 5.6)
val gameUserTwo = GameUser(
    firstName = "Heath",
    lastName = "Ledger",
    userName = "TheJoker",
    registrationNumber = 777)