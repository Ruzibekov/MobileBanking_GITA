package uz.ruzibekov.gita_bank_app.data.model.request

data class SignUpVerifyRequest(
    val token: String,
    val code: String
)