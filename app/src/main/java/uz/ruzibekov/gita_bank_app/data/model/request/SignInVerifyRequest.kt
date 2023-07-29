package uz.ruzibekov.gita_bank_app.data.model.request

data class SignInVerifyRequest (val token: String, val code: String)