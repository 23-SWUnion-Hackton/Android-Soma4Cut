package com.staker4wapper.android_soma4cut.feature.search.screen

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSearchBinding
import com.staker4wapper.android_soma4cut.feature.search.viewmodel.SearchViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by activityViewModels()

    private lateinit var context: Context
    private lateinit var etSearch: String

    override fun start() {
        context = requireContext()
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.etSearch.requestFocus()

        lifecycleScope.launch {
            viewModel.searchState.collect {
                if (it.isSuccess) {
                    viewModel.searchCode.observe(viewLifecycleOwner) { code ->
                        val action = SearchFragmentDirections.toSearchResultFragment(code)
                        findNavController().navigate(action)
                    }
                }
                if (it.error.isNotEmpty()) {
                    makeToast(context, "코드를 다시 확인해주세요")
                }
            }
        }
        binding.btnSearch.setOnClickListener {
            etSearch = binding.etSearch.text.toString()

            if (etSearch.isNotEmpty()) {
                viewModel.searchCode(etSearch)
            } else {
                Toast.makeText(context, "코드를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}