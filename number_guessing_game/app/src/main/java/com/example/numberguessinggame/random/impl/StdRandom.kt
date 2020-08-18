package com.example.numberguessinggame.random.impl

import com.example.numberguessinggame.random.RandomNumberGenerator

class StdRandom: RandomNumberGenerator {
    override fun rnd(minInt: Int, maxInt: Int): Int {
        val span = maxInt - minInt + 1
        return minInt + Math.floor(Math.random()*span).toInt()
    }
}