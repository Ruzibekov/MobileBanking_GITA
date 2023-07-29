package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.gita_bank_app.data.remote.AuthService
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.state.SignUpVerifyState
import javax.inject.Inject

@HiltViewModel
class SignUpVerifyViewModel @Inject constructor(
    private val service: AuthService
) : ViewModel() {

    val state = SignUpVerifyState()

    fun verifyCode() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = service.signUpVerify(state.token, state.codeState.value).body()
            Log.i("RRR", response.toString())
        }
    }
}