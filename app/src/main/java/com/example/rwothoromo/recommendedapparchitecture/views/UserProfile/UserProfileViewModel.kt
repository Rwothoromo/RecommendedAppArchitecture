package com.example.rwothoromo.recommendedapparchitecture.views.UserProfile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.rwothoromo.recommendedapparchitecture.domain.data.repository.implementations.UserRepository


class UserProfileViewModel// Instructs Dagger 2 to provide the UserRepository parameter.
@Inject
constructor(private val userRepo: UserRepository) : ViewModel() {
    var user: LiveData<User>? = null
        private set

    fun init(userId: Int) {
        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return
        }
        user = userRepo.getUser(userId)
    }

    fun getUser(): LiveData<User> {
        return this.user
    }
}

/* Based on https://developer.android.com/jetpack/docs/guide */