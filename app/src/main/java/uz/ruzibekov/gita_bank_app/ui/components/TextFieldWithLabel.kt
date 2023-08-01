package uz.ruzibekov.gita_bank_app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor

object TextFieldWithLabel {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        labelRes: Int,
        value: String,
        focusRequester: FocusRequester,
        onValueChange: (String) -> Unit,
        placeholderRes: Int? = null,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardType: KeyboardType = KeyboardType.Text,
        onDone: () -> Unit
    ) {

        Column {

            Text(
                text = stringResource(labelRes),
                style = MaterialTheme.typography.labelMedium,
                color = AppColor.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                border = BorderStroke(
                    width = 1.dp,
                    color = if (false) AppColor.Blue
                    else AppColor.Light
                ),
                shape = RoundedCornerShape(12.dp),
                color = AppColor.Light
            ) {

                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {

                        if (placeholderRes != null)
                            Text(
                                text = stringResource(placeholderRes),
                                style = MaterialTheme.typography.bodyMedium,
                                color = AppColor.Black_30
                            )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { onDone.invoke() }
                    ),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = keyboardType
                    ),
                    visualTransformation = visualTransformation,
                )
            }
        }
    }
}