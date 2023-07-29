package uz.ruzibekov.gita_bank_app

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uz.ruzibekov.gita_bank_app.ui.components.TextFieldWithLabel

class Preview {

    @SuppressLint("NotConstructor")
    @Preview
    @Composable
    fun Preview() {
        TextFieldWithLabel.Default(
            labelRes = R.string.title_sign_up,
            value = "hello",
            onValueChange = {},
            placeholderRes = R.string.app_name
        )
    }
}