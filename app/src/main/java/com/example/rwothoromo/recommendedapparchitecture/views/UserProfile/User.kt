package com.example.rwothoromo.recommendedapparchitecture.views.UserProfile

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
internal class User {
    @PrimaryKey
    private val id: Int = 0
    private val name: String? = null
    private val lastName: String? = null

    // Getters and setters for fields.
}

/* Based on https://developer.android.com/jetpack/docs/guide */