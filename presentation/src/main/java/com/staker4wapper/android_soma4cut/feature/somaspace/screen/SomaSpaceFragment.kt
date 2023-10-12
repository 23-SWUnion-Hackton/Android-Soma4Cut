package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceBinding
import com.staker4wapper.android_soma4cut.feature.home.recyclerview.Code
import com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview.SomaSpaceCodeListAdapter
import com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview.SomaSpaceImageListAdapter
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel

class SomaSpaceFragment: BaseFragment<FragmentSomaSpaceBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space) {

    override val viewModel: SomaSpaceViewModel by viewModels()

    private val imageList = mutableListOf(
        R.drawable.img_test,
        R.drawable.img_test,
        R.drawable.img_test,
        R.drawable.img_test,
        R.drawable.img_test,
    )

    override fun start() {
        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        setCodeListAdapter()

        binding.btnPlus.setOnClickListener {
            val action = SomaSpaceFragmentDirections.toSomaSpaceSelectCodeFragment()
            findNavController().navigate(action)
        }
    }

    private fun setCodeListAdapter() {
        val frameListAdapter = SomaSpaceImageListAdapter(imageList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = frameListAdapter
    }
}