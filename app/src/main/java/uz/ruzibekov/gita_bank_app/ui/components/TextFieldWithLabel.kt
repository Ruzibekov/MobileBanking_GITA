package uz.ruzibekov.gita_bank_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor

object TextFieldWithLabel {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        labelRes: Int,
        value: String,
        onValueChange: (String) -> Unit,
        placeholderRes: Int? = null
    ) {
        Column {

            Text(
                text = stringResource(labelRes),
                style = MaterialTheme.typography.labelMedium,
                color = AppColor.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                border = BorderStroke(1.dp, AppColor.Blue),
                shape = RoundedCornerShape(12.dp),
                color = AppColor.Light
            ) {

                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {

                        if (placeholderRes != null)
                            Text(
                                text = stringResource(placeholderRes),
                                style = MaterialTheme.typography.bodyMedium,
                                color = AppColor.Black_30
                            )
                    },
                )
            }
        }
    }
}