package com.example.numberguessinggame

object Constants{
    // Singleton object that does not need its state changed. Good usages for Singletons
    // are Constants, Preferences, Utilities, and Databases. This feature should not be used often.
    // immutable instance-independent constants
    val LOWER_BOUNDS = 1
    val UPPER_BOUNDS = 7
}

object Window {
    val NUMBER_OF_TABS = 5
    val WINDOW_TITLE = "Astaria"
    val PREFS_FILE = "prefs.properties"
}
