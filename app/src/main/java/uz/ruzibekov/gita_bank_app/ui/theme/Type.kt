package uz.ruzibekov.gita_bank_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import uz.ruzibekov.gita_bank_app.R

val Poppins = FontFamily(
    Font(R.font.ft_poppins_regular, FontWeight.Normal),
    Font(R.font.ft_poppins_medium, FontWeight.Medium),
    Font(R.font.ft_poppins_semibold, FontWeight.SemiBold),
    Font(R.font.ft_poppins_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(

    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),

    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)