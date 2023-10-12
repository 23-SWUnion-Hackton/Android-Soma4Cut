package com.staker4wapper.android_soma4cut.feature.search.screen

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentSearchBinding
import com.staker4wapper.android_soma4cut.feature.search.viewmodel.SearchViewModel


class SearchFragment: BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.etSearch.requestFocus()

        binding.btnSearch.setOnClickListener {
            val etSearch = binding.etSearch.text.toString()

            /** Code Handling */
            if (etSearch.isNotEmpty()) {
                // todo 1. 만약 있는 code라면 -> 창 넘기기
                if (etSearch == "1234") {
                    val action = SearchFragmentDirections.toSearchResultFragment(etSearch)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(context, "형식에 맞게 코드를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "코드를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun showSoftKeyboard(view: View) {
//        if (view.requestFocus()) {
//            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
//        }
//    }

}