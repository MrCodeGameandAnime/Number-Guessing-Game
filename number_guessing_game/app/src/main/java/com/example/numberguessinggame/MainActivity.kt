package com.example.numberguessinggame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.xml.sax.Attributes
import kotlin.math.log

// Number Guessing Game from Big Nerd Ranch v4 chapter 2

class MainActivity : AppCompatActivity() {
    // property types do not need to be explicit whereas Kotlin infers the data type
    var started = false
    var number = 0
    var tries = 0

    // class visibility modifiers are as follows:
    // public: default setting, the class can be instantiated from inside and outside of program
    // private the class can only be instantiated from within the class or object
    // protected instantiation is the same as private along with subclasses
    // internal the constructor can be accessed from anywhere in the module while being locked out from other programs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchSavedInstanceData(savedInstanceState)
        doGuess.setEnabled(started)

        var gameUser = GameUser("Jack","Black","0983451289",
            4,"03/22/76",60.9) // Exercise 12

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        putInstanceData(outState)
    }

    fun start(v:View) {
        log("Game started")
        num.setText("")
        started = true
        doGuess.setEnabled(true)
        status.text = getString(R.string.guess_hint,1,7)
        number = 1 + Math.floor(Math.random()*7).toInt()
        tries = 0
    }

    fun guess(v:View) {
        if (num.text.toString() == "") return
        tries++
        log("Guessed ${num.text} (tries:${tries})")
        val g = num.text.toString().toInt()
        if (g < number) {
            status.setText(R.string.status_too_low)
            num.setText("")
        } else if(g > number) {
            status.setText(R.string.status_too_high)
            num.setText("")
        } else {
            status.text = getString(R.string.status_hit,tries)
            started = false
            doGuess.setEnabled(false)
        }
    }



    private fun putInstanceData(outState: Bundle) {
        if (outState != null) with(outState) {
            putBoolean("started",started)
            putInt("number",number)
            putInt("tries",tries)
            putString("statusMsg",status.text.toString())
            putStringArrayList("logs", ArrayList(console.text.split("\n")))
        }
    }

    private fun fetchSavedInstanceData(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) with(savedInstanceState) {
            started = getBoolean("started")
            number = getInt("number")
            tries = getInt("tries")
            status.text = getString("statusMsg")
            console.text = getStringArrayList("logs")!!.joinToString("\n")
        }
    }

    private fun log(msg:String) {
        Log.d("LOG", msg)
        console.log(msg)
    }
}

// Primary constructor that creates a custom View object
class Console(ctx:Context,aset:AttributeSet? = null): ScrollView(ctx,aset) {
    val tv = TextView(ctx)
    var text:String
        get() = tv.text.toString()
        set(value) { tv.setText(value) }
    init {
        // creating property objects
        setBackgroundColor(0x40FFFF00)
        addView(tv)
    }

    fun log(msg:String) {
        val l = tv.text.let {
            if (it == "") listOf() else it.split("\n")
        }.takeLast(100) + msg
        tv.text = l.joinToString("\n")
        post(object : Runnable {
            override fun run() {
                fullScroll(ScrollView.FOCUS_DOWN)
            }
        })
    }
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
               val birthday:String = "1910-06-07", // Exercise 10/ Exercise 14
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

object ObjectName {
    // Singleton object that does not need its state changed. Good usages for Singletons
    // are Constants, Preferences, Utilities, and Databases. This feature should not be used often.
}