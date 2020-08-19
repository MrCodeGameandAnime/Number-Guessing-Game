package com.example.numberguessinggame.model

class GameUser(val firstName:String,val lastName:String,val userName:String, val registrationNumber:Int,
               val birthday:String = "1910-06-07",val userRank:Double = 0.0) { // Exercise 10 and Exercise 14
    val fullName:String
    val initials:String // Exercise 1

    init {
        fullName = firstName +" "+ lastName
        initials = firstName.toUpperCase() + lastName.toUpperCase()
    }
    // Secondary constructor
    constructor(firstName: String,lastName: String,userName: String,registrationNumber: Int) :
            this(firstName = firstName,lastName = lastName,userName = userName,registrationNumber = registrationNumber,
                birthday = " ",userRank = 0.0)
}