package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify._content.SignInContentView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.verify.listeners.SignInVerifyListeners

@AndroidEntryPoint
class SignInVerifyActivity : ComponentActivity(), SignInVerifyListeners {

    private val viewModel: SignInVerifyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { SignInContentView.Default(listeners = this) }
    }

    override fun signInVerify() {
        viewModel.signInVerify()
    }
}