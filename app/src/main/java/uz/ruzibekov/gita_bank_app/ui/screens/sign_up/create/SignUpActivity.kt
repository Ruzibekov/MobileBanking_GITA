package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.content.SignUpScreen
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.listeners.SignUpListeners
import uz.ruzibekov.gita_bank_app.ui.theme.GITA_Bank_AppTheme

@AndroidEntryPoint
class SignUpActivity : ComponentActivity(), SignUpListeners {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GITA_Bank_AppTheme {
                SignUpScreen.Default(state = viewModel.state, listeners = this)
            }
        }

        initObservers()
    }

    private fun initObservers() {

        lifecycleScope.launch {
            viewModel.messageStateFlow.collect { showToast(it) }
        }

        lifecycleScope.launch {
            viewModel.signUpSuccessfulStateFlow.collect { response ->
                if(response != null)
                    viewModel.signUpVerify()
            }
        }
    }

    override fun signUp() {
        viewModel.signUp()
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}