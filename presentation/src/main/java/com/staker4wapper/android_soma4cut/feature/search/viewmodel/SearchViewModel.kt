package com.staker4wapper.android_soma4cut.feature.search.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.staker4wapper.android_soma4cut.base.BaseViewModel
import com.staker4wapper.android_soma4cut.feature.search.state.SaveState
import com.staker4wapper.android_soma4cut.feature.search.state.SearchState
import com.staker4wapper.android_soma4cut.utils.makeToast
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.SaveCodeRequestModel
import com.staker4wapper.domain.repository.CodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val codeRepository: CodeRepository
): BaseViewModel() {

    private val _searchState = MutableSharedFlow<SearchState>()
    val searchState: SharedFlow<SearchState> = _searchState

    private val _saveState = MutableSharedFlow<SaveState>()
    val saveState: SharedFlow<SaveState> = _saveState

    private var _searchCode = MutableLiveData<Code>()
    val searchCode: LiveData<Code> = _searchCode

    fun searchCode(code: String) = viewModelScope.launch {
        kotlin.runCatching {
            codeRepository.searchCode(code)
        }.onSuccess {
            Log.d(TAG, "searchCode: success!! $it")
            _searchCode.value = it
            _searchState.emit(SearchState(isSuccess = true))
        }.onFailure { e ->
            Log.d(TAG, "searchCode: failed.. $e")
            _searchState.emit(SearchState(error = "$e"))
        }
    }

    fun saveCode(codeRequestModel: SaveCodeRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            codeRepository.saveCode(codeRequestModel)
        }.onSuccess {
            Log.d(TAG, "saveCode: success!! $it")
            _saveState.emit(SaveState(isSuccess = true))
        }.onFailure { e ->
            Log.d(TAG, "saveCode: failed.. $e")
            _saveState.emit(SaveState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "SearchViewModel"
    }
}