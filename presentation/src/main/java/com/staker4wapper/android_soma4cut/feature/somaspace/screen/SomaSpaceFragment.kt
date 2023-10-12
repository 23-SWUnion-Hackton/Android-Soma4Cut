package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import android.content.Context
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceBinding
import com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview.SomaSpaceImageListAdapter
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel
import com.staker4wapper.domain.model.space.Image
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SomaSpaceFragment: BaseFragment<FragmentSomaSpaceBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space) {

    override val viewModel: SomaSpaceViewModel by viewModels()

    private val imageList: MutableList<Image> = mutableListOf()

    private lateinit var context: Context

    override fun start() {
        viewModel.getSomaSpaceImages()
        context = requireContext()
        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        observeSomaSpaceImageList()

        binding.btnPlus.setOnClickListener {
            val action = SomaSpaceFragmentDirections.toSomaSpaceSelectCodeFragment()
            findNavController().navigate(action)
        }
    }

    private fun observeSomaSpaceImageList() {
        viewModel.somaSpaceImageList.observe(viewLifecycleOwner) { somaImageList ->
            imageList.removeAll(imageList)
            somaImageList.forEach { image ->
                imageList.add(image)
            }
            setCodeListAdapter()
        }
    }

    private fun setCodeListAdapter() {
        val frameListAdapter = SomaSpaceImageListAdapter(imageList, context)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = frameListAdapter
    }
}