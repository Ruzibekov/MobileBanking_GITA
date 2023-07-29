package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify._content

import androidx.compose.runtime.Composable
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify.listeners.SignInVerifyListeners

object SignInContentView {

    @Composable
    fun Default(listeners: SignInVerifyListeners) {

        PrimaryButton.Default(textRes = R.string.title_sign_in) {
            listeners.signInVerify()
        }
    }
}