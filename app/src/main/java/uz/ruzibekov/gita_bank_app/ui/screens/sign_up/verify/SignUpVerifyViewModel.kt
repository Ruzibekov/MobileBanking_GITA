package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpVerifyRequest
import uz.ruzibekov.gita_bank_app.domain.auth.AuthRepository
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.state.SignUpVerifyState
import javax.inject.Inject

@HiltViewModel
class SignUpVerifyViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val state = SignUpVerifyState()

    val messageStateFlow: MutableStateFlow<String?> = MutableStateFlow(null)

    fun verifyCode() {
        viewModelScope.launch(Dispatchers.IO) {

            repository.signUpVerify(
                SignUpVerifyRequest(state.token, state.codeState.value)
            ).onEach { result ->
                result.run {

                    onSuccess {
                        Log.i("RRR", it.accessToken)
                    }

                    onFailure {
                        messageStateFlow.value = it.message
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}