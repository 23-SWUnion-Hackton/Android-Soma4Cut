package com.staker4wapper.android_soma4cut.feature.start.screen

import androidx.fragment.app.viewModels
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentStartBinding
import com.staker4wapper.android_soma4cut.feature.start.viewmodel.StartViewModel

class StartFragment: BaseFragment<FragmentStartBinding, StartViewModel>(R.layout.fragment_start) {

    override val viewModel: StartViewModel by viewModels()

    override fun start() {

    }

}