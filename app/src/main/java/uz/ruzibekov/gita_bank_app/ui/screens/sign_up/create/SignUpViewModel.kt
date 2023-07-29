package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse
import uz.ruzibekov.gita_bank_app.data.remote.AuthService
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.state.SignUpState
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {

    val state = SignUpState()

    val messageStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val signUpSuccessfulStateFlow: MutableStateFlow<SignUpResponse?> = MutableStateFlow(null)

    fun signUp() {
        messageStateFlow.value = "auth run"

        viewModelScope.launch(Dispatchers.IO) {
            authService.signUp(getSignUpRequest()).enqueue(object : Callback<SignUpResponse> {

                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    signUpSuccessfulStateFlow.value = response.body()
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    messageStateFlow.value = "Failed"
                }
            })
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