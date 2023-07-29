package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ruzibekov.gita_bank_app.data.model.request.SignInVerifyRequest
import uz.ruzibekov.gita_bank_app.domain.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignInVerifyViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    fun signInVerify() {
        repository.signInVerify(
            SignInVerifyRequest(
                token = "", //todo
                code = "" //todo
            )
        ).onEach {

        }.launchIn(viewModelScope)
    }
}