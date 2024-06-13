package com.example.mvvmlogin.frameworks

import com.example.mvvmlogin.data.users.network.service.UserApiServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val URL_BASE_RETROFIT = "http://10.0.2.2:8008/api-usuarios/endp/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(URL_BASE_RETROFIT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Singleton
    @Provides
    fun provideServiceApi(retrofit: Retrofit): UserApiServiceInterface =
        retrofit
            .create(UserApiServiceInterface::class.java)
}