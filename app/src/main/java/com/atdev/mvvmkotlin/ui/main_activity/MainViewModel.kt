package com.atdev.mvvmkotlin.ui.main_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.atdev.mvvmkotlin.pojo.models.User
import com.atdev.mvvmkotlin.pojo.repos.RepoGetUSer

class MainViewModel : ViewModel() {

    private var _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userId) {

                userID ->
            RepoGetUSer.getUSer(userID)
        }

    fun setUSerId(userID: String) {

        val update = userID
        if (_userId.value == update) {
            return
        }
        _userId.value = update
    }
    //..

    fun cancelJobs() {
        RepoGetUSer.cancelJob()
    }
    //..
}
//A SwitchMap flattens the source observable but only returns the last emitted single observable.
//SwitchMap would emit only the latest observable after a particular delay. It ignores all the previous ones.
//It is useful when it comes to retrieving the latest data from a feed.
// It’s useful when you need to identify the latest among many feeds.