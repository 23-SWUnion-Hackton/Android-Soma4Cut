package com.staker4wapper.android_soma4cut.feature.start.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.staker4wapper.android_soma4cut.base.BaseViewModel
import com.staker4wapper.android_soma4cut.feature.start.state.LoginState
import com.staker4wapper.android_soma4cut.feature.start.state.SignupState
import com.staker4wapper.android_soma4cut.utils.HiltApplication
import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.data.repository.AuthRepositoryImpl
import com.staker4wapper.domain.model.auth.LoginRequestModel
import com.staker4wapper.domain.model.auth.SignupRequestModel
import com.staker4wapper.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val authRepository: AuthRepository
): BaseViewModel() {

    private val _signupState = MutableSharedFlow<SignupState>()
    val signupState: SharedFlow<SignupState> = _signupState

    private val _loginState = MutableSharedFlow<LoginState>()
    val loginState: SharedFlow<LoginState> = _loginState

    fun signup(signupRequestModel: SignupRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            authRepository.signup(signupRequestModel)
        }.onSuccess {
            Log.d(TAG, "signup: success!! $it")
            _signupState.emit(SignupState(isSuccess = true))
        }.onSuccess { e ->
            Log.d(TAG, "signup: failed.. $e")
            _signupState.emit(SignupState(error = "$e"))
        }
    }

    fun login(loginRequestModel: LoginRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            authRepository.login(loginRequestModel)
        }.onSuccess {
            Log.d(TAG, "signup: success!! $it")
            _loginState.emit(LoginState(isSuccess = true))
            HiltApplication.prefs.accessToken = it.accessToken
            HiltApplication.prefs.refreshToken = it.refreshToken
            HiltApplication.prefs.autoLogin = true
        }.onFailure { e ->
            Log.d(TAG, "signup: failed.. $e")
            _loginState.emit(LoginState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "StartViewModel"
    }
}