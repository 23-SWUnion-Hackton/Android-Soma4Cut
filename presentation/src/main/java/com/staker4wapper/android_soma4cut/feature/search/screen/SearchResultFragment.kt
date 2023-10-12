package com.staker4wapper.android_soma4cut.feature.search.screen

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSearchResultBinding
import com.staker4wapper.android_soma4cut.feature.search.viewmodel.SearchViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.SaveCodeRequestModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchResultFragment: BaseFragment<FragmentSearchResultBinding, SearchViewModel>(R.layout.fragment_search_result) {

    override val viewModel: SearchViewModel by activityViewModels()

    private val args: SearchResultFragmentArgs by navArgs()

    private lateinit var context: Context
    private lateinit var code: Code

    override fun start() {
        context = requireContext()
        code = args.code
        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        setData()

        lifecycleScope.launch {
            viewModel.saveState.collect {
                if (it.isSuccess) {
                    makeToast(context, "코드가 저장되었어요")
                }
                if (it.error.isNotEmpty()) {
                    makeToast(context, "코드 저장에 오류가 생겼어요")
                }
            }
        }

        binding.btnSave.setOnClickListener {
            viewModel.saveCode(SaveCodeRequestModel(code.code))
        }
        binding.btnCopy.setOnClickListener {
            Toast.makeText(context, "복사", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setData() {
        binding.tvSearchedCode.text = code.code
        binding.tvSearchedCodeDate.text = code.createdAt.slice(0..9)

        val imageCount = code.image.lastIndex + 1

        if (imageCount == 1) {
            Glide.with(context).load(code.image[0]).into(binding.ivImage1)
            binding.ivImage1.layoutParams.height = 2000
            binding.ivImage2.visibility = View.GONE
            binding.ivImage3.visibility = View.GONE
            binding.ivImage4.visibility = View.GONE
        } else if (imageCount == 2) {
            Glide.with(context).load(code.image[0]).into(binding.ivImage1)
            Glide.with(context).load(code.image[1]).into(binding.ivImage2)
            binding.ivImage3.visibility = View.GONE
            binding.ivImage4.visibility = View.GONE
        } else if (imageCount == 4) {
            Glide.with(context).load(code.image[0]).into(binding.ivImage1)
            Glide.with(context).load(code.image[1]).into(binding.ivImage2)
            Glide.with(context).load(code.image[2]).into(binding.ivImage3)
            Glide.with(context).load(code.image[3]).into(binding.ivImage4)
        }
    }

}