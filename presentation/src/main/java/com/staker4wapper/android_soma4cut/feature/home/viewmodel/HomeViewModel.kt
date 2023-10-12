package com.staker4wapper.android_soma4cut.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.staker4wapper.android_soma4cut.base.BaseViewModel
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes
import com.staker4wapper.domain.repository.CodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val codeRepository: CodeRepository
): BaseViewModel() {

    private var _myCodeList = MutableLiveData<List<Code>>()
    val myCodeList: LiveData<List<Code>> = _myCodeList

    fun getCodes() = viewModelScope.launch {
        kotlin.runCatching {
            codeRepository.getCodes()
        }.onSuccess {
            Log.d(TAG, "getCodes: success!! $it")
            _myCodeList.value = it
        }.onFailure { e ->
            Log.d(TAG, "getCodes: failed.. $e")
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}