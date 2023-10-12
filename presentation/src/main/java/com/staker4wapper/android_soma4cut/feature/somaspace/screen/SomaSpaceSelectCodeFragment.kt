package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceSelectCodeBinding
import com.staker4wapper.android_soma4cut.feature.home.screen.HomeFragmentDirections
import com.staker4wapper.android_soma4cut.feature.somaspace.recyclerview.SomaSpaceCodeListAdapter
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel
import com.staker4wapper.domain.model.code.Code

class SomaSpaceSelectCodeFragment: BaseFragment<FragmentSomaSpaceSelectCodeBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space_select_code), SomaSpaceCodeListAdapter.OnClickListener{

    override val viewModel: SomaSpaceViewModel by viewModels()

    private val codeList = mutableListOf(
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
        Code("ADED-DASE", "2023년 10월 10일"),
    )

    override fun start() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        setCodeListAdapter()

        binding.etCode.setOnClickListener {
            val action = SomaSpaceSelectCodeFragmentDirections.toSomaSpaceInputCodeFragment()
            findNavController().navigate(action)
        }
    }

    private fun setCodeListAdapter() {
        val frameListAdapter = SomaSpaceCodeListAdapter(codeList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = frameListAdapter
    }

    override fun onMyAccountItemClick(position: Int) {
        val codeContainer = codeList[position]
        Toast.makeText(context, "is Clicked!", Toast.LENGTH_SHORT).show()

        val action = HomeFragmentDirections.toCodeSavedFragment(codeContainer.code)
        findNavController().navigate(action)
    }

}