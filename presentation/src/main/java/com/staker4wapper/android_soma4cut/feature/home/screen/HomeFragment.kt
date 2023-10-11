package com.staker4wapper.android_soma4cut.feature.home.screen

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentHomeBinding
import com.staker4wapper.android_soma4cut.feature.home.recyclerview.CodeListAdapter
import com.staker4wapper.android_soma4cut.feature.home.viewmodel.HomeViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home), CodeListAdapter.OnClickListener {

    override val viewModel: HomeViewModel by viewModels()

    private lateinit var context: Context
    private val frameList = mutableListOf(
        "asdf-asdf",
        "asdf-asdf",
        "asdf-asdf",
        "asdf-asdf",
        "asdf-asdf",
    )

    override fun start() {
        context = requireContext()
        setCodeListAdapter()

        binding.btnSomaSpace.setOnClickListener {
            Toast.makeText(context, "소마스페이스", Toast.LENGTH_SHORT).show()
        }
        binding.linearSearchBar.setOnClickListener {
            Toast.makeText(context, "코드 등록", Toast.LENGTH_SHORT).show()
        }
        binding.btnSetting.setOnClickListener {
            Toast.makeText(context, "세팅", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setCodeListAdapter() {
        val frameListAdapter = CodeListAdapter(frameList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = frameListAdapter
    }

    override fun onMyAccountItemClick(position: Int) {
        val clickAccount = frameList[position]
        Toast.makeText(context, "is Clicked!", Toast.LENGTH_SHORT).show()

//        val action = SendWhereFragmentDirections.actionSendWhereFragmentToSendPointFragment()
//        findNavController().navigate(action)
    }

}