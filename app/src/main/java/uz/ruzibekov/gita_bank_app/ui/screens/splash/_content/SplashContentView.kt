package uz.ruzibekov.gita_bank_app.ui.screens.splash._content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.gita_bank_app.R
import uz.ruzibekov.gita_bank_app.ui.theme.AppColor

object SplashContentView {

    @Composable
    fun Default() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColor.Background),
            contentAlignment = Alignment.Center
        ) {
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
                    color = AppColor.White
                )
            }
        }
    }
}