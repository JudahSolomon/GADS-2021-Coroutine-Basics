package com.example.coroutines

import kotlinx.coroutines.*

class UserDataManager {

    //creating a suspend fun which returns a count pf 50 and run on the Main Thread
    suspend fun getUserTotalCount():Int{
        var count = 0
        CoroutineScope (Dispatchers.Main).launch {
            delay(1000)
            count = 50
        }
        val deferred =  CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            return@async 70
        }

        return count + deferred.await()
    }
}