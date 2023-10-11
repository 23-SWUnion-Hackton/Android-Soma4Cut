package com.staker4wapper.android_soma4cut.feature.start.screen

import androidx.fragment.app.viewModels
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentLoginBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel

class LoginFragment: BaseFragment<FragmentLoginBinding, StartViewModel>(R.layout.fragment_login) {

    override val viewModel: StartViewModel by viewModels()

    override fun start() {

    }

}