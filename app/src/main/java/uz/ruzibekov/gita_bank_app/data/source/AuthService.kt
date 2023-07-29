package uz.ruzibekov.gita_bank_app.data.source

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse

interface AuthService {

    @POST("auth/sign-up")
    fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    fun signUpVerify(@Body token: String, code: String): Response<String>



}