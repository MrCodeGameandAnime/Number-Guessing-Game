package com.example.numberguessinggame

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.numberguessinggame.common.Constants
import kotlinx.android.synthetic.main.activity_main.*
import com.example.numberguessinggame.gui.Console

// Number Guessing Game from Big Nerd Ranch v4 chapter 2

class MainActivity : AppCompatActivity() {
    // property types do not need to be explicit whereas Kotlin infers the data type
    var started = false
    var number = 0
    var tries = 0
    private val console = Console(this,null)

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
        status.text = getString(R.string.guess_hint,
            Constants.LOWER_BOUNDS,
            Constants.UPPER_BOUNDS)
        val span = Constants.UPPER_BOUNDS - Constants.LOWER_BOUNDS + 1
        number = Constants.LOWER_BOUNDS + Math.floor(Math.random()*span).toInt()
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

