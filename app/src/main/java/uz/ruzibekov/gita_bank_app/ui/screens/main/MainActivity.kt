package uz.ruzibekov.gita_bank_app.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.ruzibekov.gita_bank_app.ui.theme.GITA_Bank_AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GITA_Bank_AppTheme {

            }
        }
    }
}