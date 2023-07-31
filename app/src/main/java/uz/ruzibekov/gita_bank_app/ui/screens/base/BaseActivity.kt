package uz.ruzibekov.gita_bank_app.ui.screens.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import uz.ruzibekov.gita_bank_app.ui.theme.GITA_Bank_AppTheme

abstract class BaseActivity : ComponentActivity() {

    abstract val content: @Composable () -> Unit

    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GITA_Bank_AppTheme {
                content.invoke()
            }
        }

        initialize()
    }
}