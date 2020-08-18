package com.example.numberguessinggame.random

import com.example.numberguessinggame.random.impl.RandomRandom
import com.example.numberguessinggame.random.impl.StdRandom

// Exercise 22
interface RandomNumberGenerator {
    fun rnd(minInt:Int,maxInt:Int): Int
}

// Usage to pass the class data to the interface
val rnd:RandomNumberGenerator = StdRandom()
val random:RandomNumberGenerator = RandomRandom()