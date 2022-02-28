package com.example.coroutines

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {

            // lunching the  downloadUserData() in a coroutine
            CoroutineScope(Dispatchers.Main).launch {
//                downloadUserData()
                // code modification

                tvUserMessage.text = UserdataManager2().
                getUserTotalCount2().toString()

            }

        }

    }

    @SuppressLint("SetTextI18n")
    private suspend fun downloadUserData() {
        for (i in 1..200000){
//            Log.i("My Tag", "Downloading user $i  in ${Thread.currentThread().name}")

            withContext(Dispatchers.Main){
                tvUserMessage.text = "Downloading user $i  in ${Thread.currentThread().name}"
            }
        }
    }
}