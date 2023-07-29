package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse
import uz.ruzibekov.gita_bank_app.domain.AuthRepository
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.state.SignUpState
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val state = SignUpState()

    val messageStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val signUpSuccessfulStateFlow: MutableStateFlow<SignUpResponse?> = MutableStateFlow(null)

    fun signUp() {
        messageStateFlow.value = "auth run"

        authRepository.signUp(getSignUpRequest())
            .onStart {
                // start loading
            }
            .onEach { result ->
                result.onSuccess { signUpSuccessfulStateFlow.value = it }
                result.onFailure { messageStateFlow.value = it.message.toString() }
            }
    }

    private fun getSignUpRequest() = SignUpRequest(
        firstName = state.firstNameState.value,
        lastName = state.lastNameState.value,
        bornDate = "969822000000", // todo for test
        phone = state.phoneNumberState.value,
        password = state.passwordState.value,
        gender = if (state.isMaleState.value) 0 else 1
    )
}