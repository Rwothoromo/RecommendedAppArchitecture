package com.example.rwothoromo.recommendedapparchitecture.domain.data.repository.implementations

import android.arch.lifecycle.LiveData
import com.example.rwothoromo.recommendedapparchitecture.domain.data.api.ApiService
import com.example.rwothoromo.recommendedapparchitecture.domain.data.db.UserDao
import com.example.rwothoromo.recommendedapparchitecture.views.UserProfile.User
import java.util.concurrent.Executor


@Singleton
class UserRepository @Inject
constructor(private val apiService: ApiService, private val userDao: UserDao, private val executor: Executor) {

    fun getUser(userId: String): LiveData<User> {
        refreshUser(userId)
        // Returns a LiveData object directly from the database.
        return userDao.load(userId.toInt())
    }

    private fun refreshUser(userId: String) {
        // Runs in a background thread.
        executor.execute {
            // Check if user data was fetched recently.
            val userExists = userDao.hasUser(FRESH_TIMEOUT)
            if (!userExists) {
                // Refreshes the data.
                val response = apiService.getUser(userId).execute()

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                userDao.save(response.body())
            }
        }
    }
}

/* Based on https://developer.android.com/jetpack/docs/guide */