package com.staker4wapper.android_soma4cut.feature.start.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSignupBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.domain.model.auth.SignupRequestModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignupFragment: BaseFragment<FragmentSignupBinding, StartViewModel>(R.layout.fragment_signup) {

    override val viewModel: StartViewModel by viewModels()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSignup.setOnClickListener {
            val etName = binding.etSignupId.text.toString()
            val etPwd = binding.etSignupPwd.text.toString()
            val etPwdCheck = binding.etSignupPwdCheck.text.toString()

            checkSignup(etName, etPwd, etPwdCheck)
        }

        lifecycleScope.launch {
            viewModel.signupState.collect { signupState ->
                if (signupState.isSuccess) {
                    toast("화원가입이 되었어요")
                    val action = SignupFragmentDirections.toLoginFragment()
                    findNavController().navigate(action)
                }
                if (signupState.error.isNotEmpty()) {
//                    toast(signupState.error)
                }
            }
        }


    }

    private fun checkSignup(etName: String, etPwd: String, etPwdCheck: String) {
        if (etName.isNotEmpty() && etPwd.isNotEmpty() && etPwdCheck.isNotEmpty()) {
            if (etPwd == etPwdCheck) {
                viewModel.signup(SignupRequestModel(etName, etPwd))
            } else {
                toast("비밀번호가 같은지 다시 확인해주세요")
            }
        } else {
            toast("입력을 다시 확인해주세요")
        }
    }

    private fun toast(message: String) {
        makeToast(context, message)
    }

}