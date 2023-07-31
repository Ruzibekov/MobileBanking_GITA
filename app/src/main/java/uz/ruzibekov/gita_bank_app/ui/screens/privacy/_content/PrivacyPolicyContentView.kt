package uz.ruzibekov.gita_bank_app.ui.screens.privacy._content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.components.PrimaryButton
import uz.ruzibekov.gita_bank_app.ui.components.TopBarView
import uz.ruzibekov.gita_bank_app.ui.screens.privacy.listeners.PrivacyPolicyListeners
import uz.ruzibekov.gita_bank_app.ui.screens.privacy.state.PrivacyPolicyState
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor
import uz.ruzibekov.gita_bank_app.ui.theme.bottomSpace
import uz.ruzibekov.gita_bank_app.ui.theme.horizontalSpace
import uz.ruzibekov.gita_bank_app.ui.theme.topSpace

object PrivacyPolicyContentView {

    @Composable
    fun Default(state: PrivacyPolicyState, listeners: PrivacyPolicyListeners) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = horizontalSpace)
                .padding(bottom = bottomSpace)
        ) {

            TopBarView.Default(
                titleRes = R.string.title_privacy_policy
            )

            Spacer(modifier = Modifier.height(topSpace))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_gita_academy),
                    contentDescription = "gita academy icon",
                    modifier = Modifier.height(24.dp)
                )

                Text(
                    text = stringResource(id = R.string.gita_bank),
                    style = MaterialTheme.typography.titleMedium,
                    color = AppColor.Black
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.privacy_policy_text),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Checkbox(
                    checked = state.isChecked.value,
                    onCheckedChange = {
                        state.isChecked.value = it
                    }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = stringResource(R.string.i_agree_to_all_terms),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            PrimaryButton.Default(
                textRes = R.string.btn_further,
                isActive = state.isChecked.value
            ) {
                listeners.openNextScreen()
            }
        }
    }
}