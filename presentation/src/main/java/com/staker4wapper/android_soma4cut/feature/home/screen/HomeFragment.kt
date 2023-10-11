package com.staker4wapper.android_soma4cut.feature.home.screen

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentHomeBinding
import com.staker4wapper.android_soma4cut.feature.home.recyclerview.FrameListAdapter
import com.staker4wapper.android_soma4cut.feature.home.viewmodel.HomeViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home), FrameListAdapter.OnClickListener {

    override val viewModel: HomeViewModel by viewModels()

    private lateinit var context: Context
    private val frameList = mutableListOf(
        R.drawable.img_frame1,
        R.drawable.img_frame2,
        R.drawable.img_frame3,
        R.drawable.img_frame4,
        R.drawable.img_frame5,
        R.drawable.img_frame6,
    )
    override fun start() {
        context = requireContext()

        val frameListAdapter = FrameListAdapter(frameList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = frameListAdapter
    }

    override fun onMyAccountItemClick(position: Int) {
        val clickAccount = frameList[position]
        Toast.makeText(context, "is Clicked!", Toast.LENGTH_SHORT).show()

//        viewModel.setDepositAccountNumber(clickAccount.accountNumber)

//        val action = SendWhereFragmentDirections.actionSendWhereFragmentToSendPointFragment()
//        findNavController().navigate(action)
    }

}