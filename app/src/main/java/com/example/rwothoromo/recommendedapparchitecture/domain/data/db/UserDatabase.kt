package com.example.rwothoromo.recommendedapparchitecture.domain.data.db

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.example.rwothoromo.recommendedapparchitecture.views.UserProfile.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

/* Based on https://developer.android.com/jetpack/docs/guide */