package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse
import uz.ruzibekov.gita_bank_app.ui.screens.base.BaseActivity
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create._content.SignUpContentView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.listeners.SignUpListeners
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.SignUpVerifyActivity

@AndroidEntryPoint
class SignUpActivity : BaseActivity(), SignUpListeners {

    private val viewModel: SignUpViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        SignUpContentView.Default(state = viewModel.state, listeners = this)
    }

    override fun initialize() {
        initObservers()
    }

    private fun initObservers() {

        lifecycleScope.launch {
            viewModel.messageStateFlow.collect { showToast(it) }
        }

        lifecycleScope.launch {
            viewModel.signUpSuccessfulStateFlow.collect { response ->
                if(response != null)
                    openSignUpVerify(response)
            }
        }
    }

    override fun signUp() {
        viewModel.signUp()
    }

    private fun openSignUpVerify(response: SignUpResponse){
        val intent = Intent(this, SignUpVerifyActivity::class.java)
        intent.putExtra(EXTRA_TOKEN, response.token)
        startActivity(intent)
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val EXTRA_TOKEN = "extra-token"
    }
}