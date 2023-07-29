package uz.ruzibekov.gita_bank_app.domain.imp

import kotlinx.coroutines.flow.flow
import uz.ruzibekov.gita_bank_app.data.model.request.SignUpRequest
import uz.ruzibekov.gita_bank_app.data.source.AuthService
import uz.ruzibekov.gita_bank_app.domain.AuthRepository
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


}