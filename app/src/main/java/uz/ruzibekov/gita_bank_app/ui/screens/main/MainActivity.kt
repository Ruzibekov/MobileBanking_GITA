package uz.ruzibekov.gita_bank_app.ui.screens.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ruzibekov.gita_bank_app.ui.theme.GITA_Bank_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GITA_Bank_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Test()
                }
            }
        }
    }
}


@Composable
fun Test() {

    var mobileNumber by rememberSaveable { mutableStateOf("") }

    Column {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                text = "Mobile number",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )
            BasicTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = { mobileNumberFilter(it) }
            )
        }
        Box(
            modifier = Modifier
                .height(1.dp)
                .padding(start = 10.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Actual value:\n$mobileNumber")
    }

}

const val mask = "xx xxx xx xx"

fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    // change the length
    val trimmed =
        if (text.text.length >= 9) text.text.substring(0..8) else text.text

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            append(trimmed[i])
            if (i == 1 || i == 4 || i == 6) {
                append(" ")
            }
        }
        pushStyle(SpanStyle(color = Color.LightGray))
        append(mask.takeLast(mask.length - length))
        toAnnotatedString()
    }
    Log.i("RRR", annotatedString.toString())

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
//            if (offset <= 1) return offset
//            if (offset <= 4) return offset + 1
//            if (offset <= 6) return offset + 2
//            if (offset <= 9) return offset + 3
//            return 10
            return when (offset) {
                in 0..1 -> offset
                in 2..4 -> offset + 1
                in 5..6 -> offset + 2
                in 7..9 -> offset + 3
                else -> 0
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
//            if (offset <= 1) return offset
//            if (offset <= 4) return offset - 1
//            if (offset <= 6) return offset - 2
//            if (offset <= 9) return offset - 3
//            return 9

            return when (offset) {
                in 0..1 -> offset
                in 2..4 -> offset - 1
                in 5..6 -> offset - 2
                in 7..9 -> offset - 3
                else -> 0
            }
        }
    }

    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}