package com.staker4wapper.android_soma4cut.feature.start.screen

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentLoginBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import com.staker4wapper.domain.model.auth.LoginRequestModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginBinding, StartViewModel>(R.layout.fragment_login) {

    override val viewModel: StartViewModel by viewModels()

    // todo 1. {"name":"nicknanana","password":"asdf123!"}

    private lateinit var context: Context

    override fun start() {
        context = requireContext()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnLogin.setOnClickListener {
            val etName = binding.etLoginId.text.toString()
            val etPwd = binding.etLoginPwd.text.toString()
            checkUser(etName, etPwd)
        }

        lifecycleScope.launch {
            viewModel.loginState.collect { loginState ->
                if (loginState.isSuccess) {
                    makeToast(context, "로그인 되었어요")
                    val action = LoginFragmentDirections.toHomeFragment()
                    findNavController().navigate(action)
                }
                if (loginState.error.isNotEmpty()) {
                    makeToast(context, "로그인에 문제가 생겼어요")
                }
            }
        }
    }

    private fun checkUser(etName: String, etPwd: String) {
        if (etName.isNotEmpty() && etPwd.isNotEmpty()) {
            viewModel.login(LoginRequestModel(etName, etPwd))
        } else {
            makeToast(context, "입력을 다시 확인해주세요")
        }
    }

}