package uz.ruzibekov.gita_bank_app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.ruzibekov.gita_bank_app.data.source.AuthService

@Module
@InstallIn(SingletonComponent::class)
object AuthServiceModule {

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
}