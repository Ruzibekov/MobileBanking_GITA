package uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login._content.SignInContentView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_in.login.listeners.SignInListeners

@AndroidEntryPoint
class SignInActivity : ComponentActivity(), SignInListeners {

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInContentView.Default(this)
        }
    }

    override fun signIn() {
        viewModel.signIn()
    }
}