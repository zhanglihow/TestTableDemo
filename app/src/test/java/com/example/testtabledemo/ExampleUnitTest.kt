package com.example.testtabledemo

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNum(){
        val start=System.currentTimeMillis()
        for(i in 1..30000000000){
            if(i%2==1L){
//                print("$i,")
            }
        }
        val end1=System.currentTimeMillis()
        println("time1=${end1-start}")
        var i=1L
        while (i<30000000000){
            if(i%2==1L){
//                print("$i,")
            }
            i+=1
        }
        val end2=System.currentTimeMillis()
        println("time1=${end2-end1}")

    }
}