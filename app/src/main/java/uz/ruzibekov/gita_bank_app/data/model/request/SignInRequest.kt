package uz.ruzibekov.gita_bank_app.data.model.request

data class SignInRequest(
    val phone: String,
    val password: String
)