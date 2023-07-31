package uz.ruzibekov.gita_bank_app.ui.screens.privacy

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.gita_bank_app.ui.screens.base.BaseActivity
import uz.ruzibekov.gita_bank_app.ui.screens.privacy._content.PrivacyPolicyContentView
import uz.ruzibekov.gita_bank_app.ui.screens.privacy.listeners.PrivacyPolicyListeners
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.SignUpActivity

@AndroidEntryPoint
class PrivacyPolicyActivity : BaseActivity(), PrivacyPolicyListeners {

    private val viewModel: PrivacyPolicyViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        PrivacyPolicyContentView.Default(viewModel.state, this)
    }

    override fun initialize() {}

    override fun openNextScreen() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}