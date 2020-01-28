package com.atdev.mvvmkotlin.ui.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atdev.mvvmkotlin.ExampleSingleTon
import com.atdev.mvvmkotlin.R
import com.atdev.mvvmkotlin.SingleTon2
import com.atdev.mvvmkotlin.pojo.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("DEBUG: ${ExampleSingleTon.singletonUser.hashCode()}")
        //hashCode give Location of the Memory
        println("DEBUG1:${SingleTon2.getInstance().hashCode()}")

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //
        viewModel.user.observe(this, Observer{ user ->

            Toast.makeText(this@MainActivity, user.username, Toast.LENGTH_LONG).show()
            println("DEBUG: user  $user")
        })

        btnGetUSer.setOnClickListener {

            viewModel.setUSerId("1")

            //
        }//
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}
