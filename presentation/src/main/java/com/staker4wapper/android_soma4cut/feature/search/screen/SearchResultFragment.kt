package com.staker4wapper.android_soma4cut.feature.search.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSearchResultBinding
import com.staker4wapper.android_soma4cut.feature.search.SearchViewModel

class SearchResultFragment: BaseFragment<FragmentSearchResultBinding, SearchViewModel>(R.layout.fragment_search_result) {

    override val viewModel: SearchViewModel by viewModels()

    private val args: SearchResultFragmentArgs by navArgs()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()
        val code = args.code

        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(context, "저장", Toast.LENGTH_SHORT).show()
        }
        binding.btnCopy.setOnClickListener {
            Toast.makeText(context, "복사", Toast.LENGTH_SHORT).show()
        }

        binding.tvSearchedCode.text = code

    }

}