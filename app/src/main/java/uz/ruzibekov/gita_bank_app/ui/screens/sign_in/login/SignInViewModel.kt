package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ruzibekov.gita_bank_app.data.model.request.SignInRequest
import uz.ruzibekov.gita_bank_app.domain.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    fun signIn() {
        repository.signIn(
            SignInRequest(
                phone = "+998901144147",
                password = "12345678"
            )
        ).onEach {
            it.onSuccess {
                Log.i("RRR", it.token)
            }
        }.launchIn(viewModelScope)
    }
}