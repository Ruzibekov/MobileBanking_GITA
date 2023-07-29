package uz.ruzibekov.gita_bank_app.data.model.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(@SerializedName("token") val token: String)