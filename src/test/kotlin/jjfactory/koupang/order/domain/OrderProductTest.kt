package jjfactory.koupang.order.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderProductTest{
    val arr = IntArray(100000000)

    @BeforeEach
    fun testSet(){
        var idx = 0
        for (i in 1 .. 100000000)
            arr[idx++] = i
    }

    @Test
    fun find1(){
        val now = System.currentTimeMillis()

        for(a in arr){
            if(a == 52000700){
                break
            }
        }
        val now2 = System.currentTimeMillis()

        println(now2 - now)
    }


    @Test
    fun find2(){
        val now = System.currentTimeMillis()

        for(a in arr){
            if(a == 3){
                break
            }
        }
        val now2 = System.currentTimeMillis()

        println(now2 - now)
    }

    @Test
    fun find3(){
        val now = System.currentTimeMillis()

        for(a in arr){
            if(a == 99999999){
                break
            }
        }
        val now2 = System.currentTimeMillis()

        println(now2 - now)
    }

    @Test
    fun find4(){
        val now = System.currentTimeMillis()

        var low = 1
        var high = 100000000
        var mid = 0

        while (high >= low){
            mid = (low + high) / 2

            if(mid == 52000700){
                break
            }

            if(mid > 52000700) low = mid -1
            else high = mid + 1
        }

        val now2 = System.currentTimeMillis()

        println(now2 - now)
    }

}