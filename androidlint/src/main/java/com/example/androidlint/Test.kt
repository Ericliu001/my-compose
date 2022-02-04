package com.example.androidlint

import com.example.mycompose.MainActivity

class Test {
    fun test() {
        print(MainActivity::class.java.canonicalName)
    }
}