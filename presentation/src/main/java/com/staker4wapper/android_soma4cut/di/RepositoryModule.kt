package com.staker4wapper.android_soma4cut.di

import com.staker4wapper.data.repository.AuthRepositoryImpl
import com.staker4wapper.data.repository.CodeRepositoryImpl
import com.staker4wapper.domain.repository.AuthRepository
import com.staker4wapper.domain.repository.CodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository = impl

    @Provides
    @Singleton
    fun provideCodeRepository(
        impl: CodeRepositoryImpl
    ): CodeRepository = impl


}