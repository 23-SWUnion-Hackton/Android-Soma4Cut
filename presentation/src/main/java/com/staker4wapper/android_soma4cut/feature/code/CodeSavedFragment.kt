package com.staker4wapper.android_soma4cut.feature.code

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
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
import com.staker4wapper.android_soma4cut.databinding.FragmentCodeSavedBinding
import com.staker4wapper.android_soma4cut.feature.somaspace.screen.SomaSpaceInputCodeFragment
import com.staker4wapper.android_soma4cut.feature.somaspace.screen.SomaSpaceInputCodeFragmentDirections
import com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel.SomaSpaceViewModel
import com.staker4wapper.android_soma4cut.utils.makeToast
import com.staker4wapper.domain.model.code.Code
import kotlinx.coroutines.launch

class CodeSavedFragment: BaseFragment<FragmentCodeSavedBinding, CodeViewModel>(R.layout.fragment_code_saved) {

    override val viewModel: CodeViewModel by activityViewModels()
    private val somaSpaceViewModel: SomaSpaceViewModel by activityViewModels()

    private val args: CodeSavedFragmentArgs by navArgs()

    private lateinit var context: Context
    private lateinit var code: Code

    override fun start() {
        code = args.code

        context = requireContext()

        binding.btnArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }

        setDatas()

        binding.btnCopy.setOnClickListener {
            copy()
        }

        lifecycleScope.launch {
            somaSpaceViewModel.postImageState.collect { postImageState ->
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

        binding.btnHandleSomaSpace.setOnClickListener {
            somaSpaceViewModel.postSomaSpaceImage(code.code)
        }
    }

    private fun setDatas() {
        binding.tvCode.text = code.code
        binding.tvCodeSavedDate.text = code.createdAt.slice(0..9)

        val imageCount = code.image.lastIndex + 1
        if (imageCount == 1) {
            val imageUrl1 = code.image[0]
            Glide.with(context).load(imageUrl1).into(binding.ivImage1)
            binding.ivImage1.layoutParams.height = 2000
            binding.ivImage2.visibility = View.GONE
            binding.ivImage3.visibility = View.GONE
            binding.ivImage4.visibility = View.GONE
        } else if (imageCount == 2) {
            val imageUrl1 = code.image[0]
            val imageUrl2 = code.image[1]
            Glide.with(context).load(imageUrl1).into(binding.ivImage1)
            Glide.with(context).load(imageUrl2).into(binding.ivImage2)
            binding.ivImage3.visibility = View.GONE
            binding.ivImage4.visibility = View.GONE
        } else if (imageCount == 4) {
            val imageUrl1 = code.image[0]
            val imageUrl2 = code.image[1]
            val imageUrl3 = code.image[2]
            val imageUrl4 = code.image[3]
            Glide.with(context).load(imageUrl1).into(binding.ivImage1)
            Glide.with(context).load(imageUrl2).into(binding.ivImage2)
            Glide.with(context).load(imageUrl3).into(binding.ivImage3)
            Glide.with(context).load(imageUrl4).into(binding.ivImage4)
        }
    }

    private fun copy() {
        val clipboard: ClipboardManager = requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", code.code)
        clipboard.setPrimaryClip(clip)
    }

    companion object {
        private const val TAG = "CodeSavedFragment"
    }

}