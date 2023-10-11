package com.staker4wapper.android_soma4cut.feature.start.screen

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentStartBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel

class StartFragment: BaseFragment<FragmentStartBinding, StartViewModel>(R.layout.fragment_start) {

    override val viewModel: StartViewModel by viewModels()

    override fun start() {
        binding.btnLogin.setOnClickListener {
            val action = StartFragmentDirections.toLoginFragment()
            findNavController().navigate(action)
        }
        binding.linearSignup.setOnClickListener {
            val action = StartFragmentDirections.toSignupFragment()
            findNavController().navigate(action)
        }

    }

}