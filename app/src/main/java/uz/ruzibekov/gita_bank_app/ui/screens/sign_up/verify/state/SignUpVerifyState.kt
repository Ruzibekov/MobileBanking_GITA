package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class SignUpVerifyState(
    val codeState: MutableState<String> = mutableStateOf(""),
    var token: String = ""
)
