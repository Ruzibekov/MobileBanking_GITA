package uz.ruzibekov.gita_bank_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.gita_bank_app.domain.AuthRepository
import uz.ruzibekov.gita_bank_app.domain.imp.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bind(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}