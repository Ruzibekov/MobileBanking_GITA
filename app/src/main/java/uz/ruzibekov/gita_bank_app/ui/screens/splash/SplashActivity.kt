package uz.ruzibekov.gita_bank_app.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import uz.ruzibekov.gita_bank_app.ui.screens.base.BaseActivity
import uz.ruzibekov.gita_bank_app.ui.screens.splash._content.SplashContentView

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override val content: @Composable () -> Unit = {
        SplashContentView.Default()
    }
}