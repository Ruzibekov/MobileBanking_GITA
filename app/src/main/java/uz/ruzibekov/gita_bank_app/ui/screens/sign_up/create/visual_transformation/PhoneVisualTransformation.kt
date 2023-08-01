package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.visual_transformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = AnnotatedString(text.formatToPhone()),
            offsetMapping = phoneOffsetMapping
        )
    }

    private fun AnnotatedString.formatToPhone(): String {
        return buildString {

            if (text.isNotEmpty()) append('+')

            if (text.length in 0..3)
                append(text)
            else if (text.length > 3){
                append(text.substring(0, 3))
                append(" ")
            }

            if (text.length in 4..5)
                append(text.substring(3))
            else if (text.length > 5){
                append(text.substring(3, 5))
                append(" ")
            }

            if (text.length in 6..8)
                append(text.substring(5))
            else if (text.length > 8){
                append(text.substring(5, 8))
                append(" ")
            }

            if (text.length in 9..10)
                append(text.substring(8))
            else if (text.length > 10){
                append(text.substring(8, 10))
                append(" ")
                append(text.substring(10))
            }
        }
    }

    private val phoneOffsetMapping = object : OffsetMapping { //998901144147
        override fun originalToTransformed(offset: Int): Int {
            return when(offset){
                in 1..3 -> offset + 1
                in 4..5 -> offset + 2
                in 6..8 -> offset + 3
                in 9..10 -> offset + 4
                in 11..12 -> offset + 5
                else -> 0
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when(offset){
                in 1..4 -> offset - 1
                in 5..7 -> offset - 2
                in 7..11 -> offset - 3
                in 11..14 -> offset - 4
                in 15..17 -> offset - 5
                else -> 0
            }
        }
    }
}