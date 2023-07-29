package uz.ruzibekov.gita_bank_app.data.model.response

import com.google.gson.annotations.SerializedName

data class SignUpVerifyResponse(
    @SerializedName("access-token") val accessToken: String,
    @SerializedName("refresh-token") val refreshToken: String
)