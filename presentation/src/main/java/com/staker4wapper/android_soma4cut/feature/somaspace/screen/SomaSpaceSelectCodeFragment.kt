package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceSelectCodeBinding
import com.staker4wapper.android_soma4cut.feature.code.CodeSavedFragment
import com.staker4wapper.android_soma4cut.feature.home.recyclerview.CodeListAdapter
import com.staker4wapper.android_soma4cut.feature.home.screen.HomeFragmentDirections
import com.staker4wapper.android_soma4cut.feature.home.viewmodel.HomeViewModel
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel
import com.staker4wapper.domain.model.code.Code

class SomaSpaceSelectCodeFragment: BaseFragment<FragmentSomaSpaceSelectCodeBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space_select_code), CodeListAdapter.OnClickListener{

    override val viewModel: SomaSpaceViewModel by viewModels()
    private val homeViewModel: HomeViewModel by activityViewModels()

    private val codeList: MutableList<Code> = mutableListOf()

    override fun start() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        observeCodeList()
        setCodeListAdapter()

        binding.etCode.setOnClickListener {
            val action = SomaSpaceSelectCodeFragmentDirections.toSomaSpaceInputCodeFragment()
            findNavController().navigate(action)
        }
    }

    private fun observeCodeList() {
        homeViewModel.myCodeList.observe(viewLifecycleOwner) { myCodeList ->
            codeList.removeAll(codeList)
            myCodeList.forEach { code ->
                codeList.add(code)
            }
            setCodeListAdapter()
        }
    }

    private fun setCodeListAdapter() {
        val frameListAdapter = CodeListAdapter(codeList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = frameListAdapter
    }

    override fun onMyAccountItemClick(position: Int) {
        val codeContainer = codeList[position]

        val action = HomeFragmentDirections.toCodeSavedFragment(codeContainer)
        findNavController().navigate(action)
    }

}