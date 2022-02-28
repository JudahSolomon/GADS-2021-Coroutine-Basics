package com.example.coroutines

import kotlinx.coroutines.*

class UserdataManager2 {
    private lateinit var deffered: Deferred<Int>

    suspend fun getUserTotalCount2():Int{
        var count = 0
        //adding structured concurrency to the child coroutine
        // with the use of the coroutineScope suspend fun
        coroutineScope{
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }
            deffered = async(Dispatchers.IO){
                delay(3000)
                return@async 70
            }


        }


return count+ deffered.await()
    }


}