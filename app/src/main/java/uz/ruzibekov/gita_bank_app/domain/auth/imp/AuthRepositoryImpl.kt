package uz.ruzibekov.gita_bank_app.domain.auth.imp

import kotlinx.coroutines.flow.flow
import uz.ruzibekov.gita_bank_app.data.model.request.SignInRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpVerifyRequest
import uz.ruzibekov.gita_bank_app.data.source.AuthService
import uz.ruzibekov.gita_bank_app.domain.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override fun signUp(request: SignUpRequest) = flow {
        val response = authService.signUp(request)

        if (response.isSuccessful && response.body() != null)
            emit(Result.success(response.body()!!))
        else
            emit(Result.failure(Exception("Failure")))
    }

    override fun signUpVerify(request: SignUpVerifyRequest) = flow {
        val response = authService.signUpVerify(request)

        if (response.isSuccessful && response.body() != null)
            emit(Result.success(response.body()!!))
        else
            emit(Result.failure(Exception("Failure")))
    }

    override fun signIn(request: SignInRequest) = flow {
        val response = authService.signIn(request)

        if (response.isSuccessful && response.body() != null)
            emit(Result.success(response.body()!!))
        else
            emit(Result.failure(Exception("Failure")))
    }

}