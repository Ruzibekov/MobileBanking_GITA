package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.listeners.SignUpVerifyListeners
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.verify.state.SignUpVerifyState

object SignUpVerifyContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: SignUpVerifyState, listeners: SignUpVerifyListeners) {
        Scaffold { _ ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Код отправлен на номер +998 90 000 90 90", //static data
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(40.dp))

                TextField(
                    value = state.codeState.value,
                    onValueChange = { state.codeState.value = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(40.dp))

                PrimaryButton.Default(textRes = R.string.title_sign_up) {
                    listeners.verifyCode()
                }
            }
        }
    }
}