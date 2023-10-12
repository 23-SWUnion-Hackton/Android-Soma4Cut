package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceInputCodeBinding
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel

class SomaSpaceInputCodeFragment: BaseFragment<FragmentSomaSpaceInputCodeBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space_input_code) {

    override val viewModel: SomaSpaceViewModel by viewModels()

    override fun start() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCodeOkay.setOnClickListener {
            // todo 1. 코드를 코드 스페이스에 올리고
            val action = SomaSpaceInputCodeFragmentDirections.toSomaSpaceFragment()
            findNavController().navigate(action)
        }

    }

}