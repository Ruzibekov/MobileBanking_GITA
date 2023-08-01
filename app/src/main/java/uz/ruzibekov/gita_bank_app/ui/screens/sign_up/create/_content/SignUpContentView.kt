package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create._content

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.components.TextFieldWithLabel
import uz.ruzibekov.gita_bank_app.ui.components.TopBarView
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.listeners.SignUpListeners
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.state.SignUpState
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.visual_transformation.DateVisualTransformation
import uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.visual_transformation.PhoneVisualTransformation
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor
import uz.ruzibekov.gita_bank_app.ui.theme.bottomSpace
import uz.ruzibekov.gita_bank_app.ui.theme.horizontalSpace
import uz.ruzibekov.gita_bank_app.ui.theme.topSpace

object SignUpContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @androidx.compose.runtime.Composable
    fun Default(
        state: SignUpState,
        listeners: SignUpListeners
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = horizontalSpace)
                .padding(bottom = bottomSpace),

            topBar = {
                TopBarView.Default(
                    titleRes = R.string.title_sign_up
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
                    .padding(top = topSpace)
            ) {

                val firstNameFocusRequester = remember { FocusRequester() }
                val lastNameFocusRequester = remember { FocusRequester() }
                val dateOfBirthFocusRequester = remember { FocusRequester() }
                val phoneFocusRequester = remember { FocusRequester() }
                val passwordFocusRequester = remember { FocusRequester() }

                LaunchedEffect(Unit) {
                    firstNameFocusRequester.requestFocus()
                }

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_first_name,
                    value = state.firstNameState.value,
                    focusRequester = firstNameFocusRequester,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { state.firstNameState.value = it },
                    onDone = { lastNameFocusRequester.requestFocus() }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_last_name,
                    value = state.lastNameState.value,
                    focusRequester = lastNameFocusRequester,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { state.lastNameState.value = it },
                    onDone = { dateOfBirthFocusRequester.requestFocus() }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_date_of_birth,
                    value = state.dateOfBirthState.value,
                    focusRequester = dateOfBirthFocusRequester,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        if (it.length < 9)
                            state.dateOfBirthState.value = it
                    },
                    placeholderRes = R.string.placeholder_date_of_birth,
                    onDone = { phoneFocusRequester.requestFocus() },
                    visualTransformation = DateVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_phone_number,
                    value = state.phoneNumberState.value,
                    focusRequester = phoneFocusRequester,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        if (it.length < 13)
                            state.phoneNumberState.value = it
                    },
                    placeholderRes = R.string.placeholder_phone_number,
                    onDone = { passwordFocusRequester.requestFocus() },
                    visualTransformation = PhoneVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldWithLabel.Default(
                    labelRes = R.string.title_password,
                    value = state.passwordState.value,
                    focusRequester = passwordFocusRequester,
                    keyboardType = KeyboardType.Password,
                    visualTransformation = if (state.showPassword.value)
                        VisualTransformation.None
                    else PasswordVisualTransformation(),
                    onValueChange = { state.passwordState.value = it },
                    onDone = { passwordFocusRequester.freeFocus() }
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