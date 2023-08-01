package uz.ruzibekov.gita_bank_app.ui.screens.sign_up.create.visual_transformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class DateVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val formattedText = AnnotatedString(text.text.getFormattedText())

        return TransformedText(text = formattedText, offsetMapping = offsetMapping)
    }

    private fun String.getFormattedText(): String {   //  28092003
        val text = this

        return buildString { // 28/09/2003
            if (text.length > 2) {
                append(text.substring(0, 2))
                append('/')
                append(text.substring(2, 3))
            } else
                append(text)

            if (text.length > 4) {
                append(text.substring(3, 4))
                append('/')
                append(text.substring(4))
            } else if (text.length > 3)
                append(text.substring(3))
        }
    }

    private val offsetMapping = object : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int {    // 28092003
            if (offset in 0..2) return offset
            if (offset in 3..4) return offset + 1
            return offset + 2
        }

        override fun transformedToOriginal(offset: Int): Int {   // 28/09/2003
            if (offset in 0..3) return offset
            if (offset in 4..5) return offset - 1
            return offset - 2
        }
    }
}