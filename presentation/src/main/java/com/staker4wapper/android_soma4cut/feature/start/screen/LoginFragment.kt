package com.staker4wapper.android_soma4cut.feature.start.screen

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentLoginBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginBinding, StartViewModel>(R.layout.fragment_login) {

    override val viewModel: StartViewModel by viewModels()

    override fun start() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnLogin.setOnClickListener {
            val etNick = binding.etLoginId.text.toString()
            val etPwd = binding.etLoginPwd.text.toString()

            if (etNick.isNotEmpty() && etPwd.isNotEmpty()) {
                val action = LoginFragmentDirections.toHomeFragment()
                findNavController().navigate(action)
            }
        }
    }

}