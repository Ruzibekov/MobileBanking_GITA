package uz.ruzibekov.gita_bank_app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor

object PrimaryButton {

    @Composable
    fun Default(
        textRes: Int,
        isActive: Boolean = true,
        onClick: () -> Unit,
    ) {

        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppColor.Blue),
            enabled = isActive
        ) {

            Text(
                text = stringResource(id = textRes),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }


}