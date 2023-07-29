package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.SignUpActivity
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.content.SignUpVerifyContentView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.listeners.SignUpVerifyListeners
import uz.ruzibekov.gita_bank_app.ui.theme.GITA_Bank_AppTheme

@AndroidEntryPoint
class SignUpVerifyActivity : ComponentActivity(), SignUpVerifyListeners {

    private val viewModel: SignUpVerifyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GITA_Bank_AppTheme {
                SignUpVerifyContentView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }

        initExtraData()

        viewModel.initObservers()
    }

    private fun initExtraData() {
        val token = intent.getStringExtra(SignUpActivity.EXTRA_TOKEN) ?: ""
        viewModel.state.token = token
    }

    private fun SignUpVerifyViewModel.initObservers() {
        messageStateFlow.onEach {
            if (it != null)
                Toast.makeText(
                    this@SignUpVerifyActivity,
                    it.toString(),
                    Toast.LENGTH_LONG
                ).show()
        }.launchIn(lifecycleScope)
    }

    override fun verifyCode() {
        viewModel.verifyCode()
    }
}