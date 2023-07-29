package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login._content

import androidx.compose.runtime.Composable
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login.listeners.SignInListeners

object SignInContentView {

    @Composable
    fun Default(listeners: SignInListeners) {
        PrimaryButton.Default(textRes = R.string.title_sign_in) {
            listeners.signIn()
        }
    }
}