package com.example.rwothoromo.recommendedapparchitecture.domain.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.rwothoromo.recommendedapparchitecture.views.UserProfile.User
import java.nio.charset.CodingErrorAction.REPLACE


@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun load(userId: Int): LiveData<User>
}

/* Based on https://developer.android.com/jetpack/docs/guide */