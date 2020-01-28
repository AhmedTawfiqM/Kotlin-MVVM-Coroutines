package com.atdev.mvvmkotlin.pojo.repos

import androidx.lifecycle.LiveData
import com.atdev.mvvmkotlin.pojo.apis.RetrofitBuider
import com.atdev.mvvmkotlin.pojo.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

object RepoGetUSer {

    var job: CompletableJob? = null

    fun getUSer(userID: String): LiveData<User> {
        job = Job()

        return object : LiveData<User>() {

            override fun onActive() {
                super.onActive()
                job?.let { thejob ->

                    CoroutineScope(Dispatchers.IO + thejob).launch {

                        val user = RetrofitBuider.apiService.getUSer(userID)
                        withContext(Main) {

                            value = user
                            thejob.complete()

                        }
                    }

                }
            }

        }
    }

    fun cancelJob() {
        job?.cancel()
    }

}