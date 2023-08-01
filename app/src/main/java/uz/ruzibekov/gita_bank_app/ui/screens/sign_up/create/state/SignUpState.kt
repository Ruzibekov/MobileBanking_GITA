package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class SignUpState (
    val firstNameState: MutableState<String> = mutableStateOf(""),
    val lastNameState: MutableState<String> = mutableStateOf(""),
    val dateOfBirthState: MutableState<String> = mutableStateOf(""),
    val phoneNumberState: MutableState<String> = mutableStateOf(""),
    val passwordState: MutableState<String> = mutableStateOf(""),
    val showPassword: MutableState<Boolean> = mutableStateOf(false),
    val isMaleState: MutableState<Boolean> = mutableStateOf(true)
)