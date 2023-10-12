package com.staker4wapper.android_soma4cut.feature.home.screen

import android.content.Context
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentHomeBinding
import com.staker4wapper.android_soma4cut.feature.home.recyclerview.CodeListAdapter
import com.staker4wapper.android_soma4cut.feature.home.viewmodel.HomeViewModel
import com.staker4wapper.domain.model.code.Code
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home), CodeListAdapter.OnClickListener {

    override val viewModel: HomeViewModel by activityViewModels()

    private lateinit var context: Context
    private val codeList: MutableList<Code> = mutableListOf()

    override fun start() {
        viewModel.getCodes()

        context = requireContext()

        observeCodeList()

        binding.btnSomaSpace.setOnClickListener {
            val action = HomeFragmentDirections.toSomaSpaceFragment()
            findNavController().navigate(action)
        }
        binding.linearSearchBar.setOnClickListener {
            val action = HomeFragmentDirections.toSearchFragment()
            findNavController().navigate(action)
        }
        binding.btnSetting.setOnClickListener {
            val action = HomeFragmentDirections.toSettingFragment()
            findNavController().navigate(action)
        }
    }

    private fun observeCodeList() {
        viewModel.myCodeList.observe(viewLifecycleOwner) { myCodeList ->
            codeList.removeAll(codeList)
            myCodeList.forEach { code ->
                codeList.add(code)
            }
            if (codeList.isNotEmpty()) {
                binding.tvNothingCode.visibility = View.INVISIBLE
            } else {
                binding.tvNothingCode.visibility = View.VISIBLE
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