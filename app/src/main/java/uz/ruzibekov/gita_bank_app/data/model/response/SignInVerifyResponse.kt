package uz.ruzibekov.gita_bank_app.data.model.response

import com.google.gson.annotations.SerializedName

data class SignInVerifyResponse (
    @SerializedName("refresh-token") val refreshToken: String,
    @SerializedName("access-token") val accessToken: String
)