package com.staker4wapper.android_soma4cut.feature.somaspace.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.staker4wapper.android_soma4cut.base.BaseViewModel
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.space.Image
import com.staker4wapper.domain.repository.SpaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SomaSpaceViewModel @Inject constructor(
    private val spaceRepository: SpaceRepository
): BaseViewModel() {

    private var _somaSpaceImageList = MutableLiveData<List<Image>>()
    val somaSpaceImageList: LiveData<List<Image>> = _somaSpaceImageList

    fun getSomaSpaceImages() = viewModelScope.launch {
        kotlin.runCatching {
            spaceRepository.getSomaSpaceImages()
        }.onSuccess {
            Log.d(TAG, "getSomaSpaceImages: success!! $it")
            _somaSpaceImageList.value = it
        }.onFailure { e ->
            Log.d(TAG, "getSomaSpaceImages: $e")
        }
    }

    companion object {
        private const val TAG = "SomaSpaceViewModel"
    }
}