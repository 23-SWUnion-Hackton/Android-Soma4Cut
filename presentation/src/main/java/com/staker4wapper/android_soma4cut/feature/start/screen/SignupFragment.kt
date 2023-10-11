package com.staker4wapper.android_soma4cut.feature.start.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSignupBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel

class SignupFragment: BaseFragment<FragmentSignupBinding, StartViewModel>(R.layout.fragment_signup) {

    override val viewModel: StartViewModel by viewModels()

    override fun start() {
        
    }

}