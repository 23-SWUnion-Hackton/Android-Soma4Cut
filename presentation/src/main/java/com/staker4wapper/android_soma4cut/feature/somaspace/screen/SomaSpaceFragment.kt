package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceBinding
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel

class SomaSpaceFragment: BaseFragment<FragmentSomaSpaceBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space) {

    override val viewModel: SomaSpaceViewModel by viewModels()

    override fun start() {
        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnPlus.setOnClickListener {
            val action = SomaSpaceFragmentDirections.toSomaSpaceSelectCodeFragment()
            findNavController().navigate(action)
        }
    }

}