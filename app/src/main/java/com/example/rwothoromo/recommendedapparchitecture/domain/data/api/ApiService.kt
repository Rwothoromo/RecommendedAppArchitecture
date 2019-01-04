package com.example.rwothoromo.recommendedapparchitecture.domain.data.api

import android.telecom.Call
import com.example.rwothoromo.recommendedapparchitecture.views.UserProfile.User


interface ApiService {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String): Call<User>
}

/* Based on https://developer.android.com/jetpack/docs/guide */