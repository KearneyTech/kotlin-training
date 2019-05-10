package com.example.myfirstapp

import com.example.myfirstapp.utils.doMath
import com.example.myfirstapp.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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
        assertEquals(4, doMath())
        /*
        val deferred = (1..1_000_000).map { n ->
            GlobalScope.async {
                n
            }
        }

        runBlocking {
            val sum = deferred.sumBy { it.await() }
            log("Sum: $sum")
        }*/

        GlobalScope.async {
            workload(3)
            /*var load = workload(3)
            log("workload $load")*/
        }
        println("Pretty Please, w/ a cherry")
    }

    suspend fun workload(n: Int): Int {
        delay(500)
        log("This is n: $n")
        return n
    }
}
