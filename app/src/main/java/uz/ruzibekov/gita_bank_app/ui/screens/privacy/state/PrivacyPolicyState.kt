package uz.ruzibekov.gita_bank_app.ui.screens.privacy.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class PrivacyPolicyState (
    val isChecked: MutableState<Boolean> = mutableStateOf(false)
)