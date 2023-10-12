package com.staker4wapper.android_soma4cut.feature.code

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sigma.flick.base.BaseFragment
import com.staker4wapper.android_soma4cut.R
import com.staker4wapper.android_soma4cut.databinding.FragmentCodeSavedBinding

class CodeSavedFragment: BaseFragment<FragmentCodeSavedBinding, CodeViewModel>(R.layout.fragment_code_saved) {

    override val viewModel: CodeViewModel by viewModels()

    private val args: CodeSavedFragmentArgs by navArgs()

    private lateinit var context: Context

    override fun start() {
        context = requireContext()
        val code = args.code

        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvCode.text = code
        // todo 0. 저장 날짜 불러오기

        // todo 1. 코드로 이미지 불러오기

        // todo 2. 복사 기능 추가하기

        // todo 3. 이 코드가 소마스페이스에 올라간 상태인지 확인하기
        var isPosted = false

        binding.btnHandleSomaSpace.setOnClickListener {
            // todo 4. 그 상태에 따라 버튼 디자인 변경하기
            if (!isPosted) {
                Toast.makeText(context, "소마스페이스에 올라갔어요", Toast.LENGTH_SHORT).show()
                val action = CodeSavedFragmentDirections.toSomaSpaceFragment()
                findNavController().navigate(action)
                isPosted = true
            } else {
                Toast.makeText(context, "소마스페이스에서 내려갔어요", Toast.LENGTH_SHORT).show()
                isPosted = false
            }
        }
    }

}