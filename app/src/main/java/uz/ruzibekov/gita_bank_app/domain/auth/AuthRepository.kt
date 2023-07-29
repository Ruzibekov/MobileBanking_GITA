package uz.ruzibekov.gita_bank_app.domain.auth

import kotlinx.coroutines.flow.Flow
import uz.ruzibekov.gita_bank_app.data.model.request.SignInRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignInVerifyRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpVerifyRequest
import uz.ruzibekov.gita_bank_app.data.model.response.SignInResponse
import uz.ruzibekov.gita_bank_app.data.model.response.SignInVerifyResponse
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpResponse
import uz.ruzibekov.gita_bank_app.data.model.response.SignUpVerifyResponse

interface AuthRepository {

    fun signUp(request: SignUpRequest): Flow<Result<SignUpResponse>>

    fun signUpVerify(request: SignUpVerifyRequest): Flow<Result<SignUpVerifyResponse>>

    fun signIn(request: SignInRequest): Flow<Result<SignInResponse>>

    fun signInVerify(request: SignInVerifyRequest): Flow<Result<SignInVerifyResponse>>
}