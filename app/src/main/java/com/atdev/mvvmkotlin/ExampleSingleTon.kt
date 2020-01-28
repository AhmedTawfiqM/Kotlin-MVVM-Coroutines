package com.atdev.mvvmkotlin

import com.atdev.mvvmkotlin.pojo.models.User

object ExampleSingleTon {

    val singletonUser: User
            by lazy(LazyThreadSafetyMode.SYNCHRONIZED)
            //LazyThreadSafetyMode.PUBLICATION
            //Default publication mode is SYNCHRONIZED meaning
            // that only single thread can initialize the given object.
            {
                User("Ahmed", "Ah123", "image.png")
            }


}