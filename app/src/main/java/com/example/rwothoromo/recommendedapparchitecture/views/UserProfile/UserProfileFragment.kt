package com.example.rwothoromo.recommendedapparchitecture.views.UserProfile

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rwothoromo.recommendedapparchitecture.R
import com.example.rwothoromo.recommendedapparchitecture.views.UserProfile.UserProfileViewModel


class UserProfileFragment : Fragment() {

    companion object {
        private val UID_KEY = "uid"
    }

    private var viewModel: UserProfileViewModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getUser().observe(this, { user ->
            // Observe the data and update the UI.
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_profile_fragment, container, false)
    }
}

/* Based on https://developer.android.com/jetpack/docs/guide */