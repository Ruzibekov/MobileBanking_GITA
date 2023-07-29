package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.content.SignUpVerifyContentView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.listeners.SignUpVerifyListeners

class SignUpVerifyActivity : AppCompatActivity(), SignUpVerifyListeners {

    private val viewModel: SignUpVerifyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SignUpVerifyContentView.Default(state = viewModel.state, listeners = this)
        }
    }

    override fun verifyCode() {
        //todo
    }
}