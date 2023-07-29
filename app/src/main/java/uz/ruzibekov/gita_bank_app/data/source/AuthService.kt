package uz.ruzibekov.gita_bank_app.data.source

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.ruzibekov.gita_bank_app.data.model.request.SignInRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpVerifyRequest
import uz.ruzibekov.gita_bank_app.data.model.response.SignInResponse
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpVerifyResponse

interface AuthService {

    @POST("auth/sign-up")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    suspend fun signUpVerify(@Body request: SignUpVerifyRequest): Response<SignUpVerifyResponse>

    @POST("auth/sign-in")
    suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>
}