package uz.ruzibekov.gita_bank_app.data.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("first-name") val firstName: String,
    @SerializedName("last-name") val lastName: String,
    @SerializedName("born-date") val bornDate: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String,
    @SerializedName("gender") val gender: Int
)