package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.components.TextFieldWithLabel
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.listeners.SignUpListeners
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.state.SignUpState
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor

object SignUpScreen {

    @OptIn(ExperimentalMaterial3Api::class)
    @androidx.compose.runtime.Composable
    fun Default(
        state: SignUpState,
        listeners: SignUpListeners
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 50.dp),
            topBar = {
                Text(
                    text = stringResource(R.string.title_sign_up),
                    style = MaterialTheme.typography.titleMedium
                )
            },
            bottomBar = {
                PrimaryButton.Default(R.string.title_sign_up) {
                    listeners.signUp()
                }
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_first_name,
                    value = state.firstNameState.value,
                    onValueChange = { state.firstNameState.value = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_last_name,
                    value = state.lastNameState.value,
                    onValueChange = { state.lastNameState.value = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_date_of_birth,
                    value = state.dateOfBirthState.value,
                    onValueChange = { state.dateOfBirthState.value = it },
                    placeholderRes = R.string.placeholder_date_of_birth
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_phone_number,
                    value = state.phoneNumberState.value,
                    onValueChange = { state.phoneNumberState.value = it },
                    placeholderRes = R.string.placeholder_phone_number
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_password,
                    value = state.passwordState.value,
                    onValueChange = { state.passwordState.value = it }
                )

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = stringResource(R.string.title_gender),
                    style = MaterialTheme.typography.labelMedium,
                    color = AppColor.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        checked = state.isMaleState.value,
                        onCheckedChange = { state.isMaleState.value = !state.isMaleState.value }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(R.string.gender_male),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.width(44.dp))

                    Checkbox(
                        checked = state.isMaleState.value.not(),
                        onCheckedChange = { state.isMaleState.value = !state.isMaleState.value }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(R.string.gender_male),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}