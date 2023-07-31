package uz.ruzibekov.gita_bank_app.ui.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.ruzibekov.gita_bank_app.ui.screens.base.BaseActivity
import uz.ruzibekov.gita_bank_app.ui.screens.privacy.PrivacyPolicyActivity
import uz.ruzibekov.gita_bank_app.ui.screens.splash._content.SplashContentView

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override val content: @Composable () -> Unit = {
        SplashContentView.Default()
    }

    override fun initialize() {
        lifecycleScope.launch {
            delay(500)
            openNextActivity()
        }
    }

    private fun openNextActivity() {
        val intent = Intent(this, PrivacyPolicyActivity::class.java)
        startActivity(intent)
    }

}