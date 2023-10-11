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

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvSavedCode.text = code
        // todo 1. 코드로 이미지 불러오기

        // todo 2. 복사 기능 추가하기

        var isClicked = false // todo 3. viewModel의 데이터로 옮기기

        binding.btnHandleSomaSpace.setOnClickListener {
            // todo 4. 이 코드가 소마스페이스에 올라간 상태인지 확인하기
            // todo 5. 그 상태에 따라 버튼 디자인 변경하기
            if (isClicked) {
                Toast.makeText(context, "소마스페이스에 올라갔어요", Toast.LENGTH_SHORT).show()
                isClicked = true
            } else {
                Toast.makeText(context, "소마스페이스에서 내려갔어요", Toast.LENGTH_SHORT).show()
                isClicked = false
            }
        }
    }

}