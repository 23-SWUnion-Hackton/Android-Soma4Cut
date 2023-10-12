package com.staker4wapper.android_soma4cut.feature.setting

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSettingBinding
import com.staker4wapper.android_soma4cut.utils.makeToast

class SettingFragment: BaseFragment<FragmentSettingBinding, SettingViewModel>(R.layout.fragment_setting) {

    override val viewModel: SettingViewModel by viewModels()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        with(binding) {
            linearUser.setOnClickListener {
                toast("유저 정보")
            }
            linearPolicy.setOnClickListener {
                toast("보안")
            }
            linearAppVersion.setOnClickListener {
                toast("앱 버전")
            }
            linearLogout.setOnClickListener {
                toast("로그아웃")
            }
        }
    }

    private fun toast(message: String) {
        makeToast(context, message)
    }

}