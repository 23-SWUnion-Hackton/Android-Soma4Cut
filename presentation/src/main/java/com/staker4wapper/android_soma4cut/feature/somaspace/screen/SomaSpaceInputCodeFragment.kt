package com.staker4wapper.android_soma4cut.feature.somaspace.screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSomaSpaceInputCodeBinding
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SomaSpaceInputCodeFragment: BaseFragment<FragmentSomaSpaceInputCodeBinding, SomaSpaceViewModel>(R.layout.fragment_soma_space_input_code) {

    override val viewModel: SomaSpaceViewModel by viewModels()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        lifecycleScope.launch {
            viewModel.postImageState.collect { postImageState ->
                if (postImageState.isSuccess) {
                    makeToast(context, "이미지를 소마스페이스에 올렸어요")
                    val action = SomaSpaceInputCodeFragmentDirections.toSomaSpaceFragment()
                    findNavController().navigate(action)
                }
                if (postImageState.error.isNotEmpty()) {
                    Log.d(TAG, "start: ${postImageState.error}")
                    makeToast(context, "코드를 다시 확인해주세요")
                }
            }
        }

        binding.btnCodeOkay.setOnClickListener {
            val etCode = binding.etCode.text.toString()

            if (etCode.isNotEmpty()) {
                viewModel.postSomaSpaceImage(etCode)
            } else {
                makeToast(context, "코드를 입력해주세요")
            }
        }

    }

    companion object {
        private const val TAG = "SomaSpaceInputCodeFragment"
    }

}