package com.sanjai.stediofitness.di

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sanjai.stediofitness.data.api.StedioFitnessApi
import com.sanjai.stediofitness.data.repository.StedioFitnessRemoteDataSourceImpl
import com.sanjai.stediofitness.data.util.Constants.BASE_URL
import com.sanjai.stediofitness.domain.repository.StedioFitnessRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(app: Application): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaTypeOrNull()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType = contentType!!))
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideStedioFitnessApi(retrofit: Retrofit): StedioFitnessApi {
        return retrofit.create(StedioFitnessApi::class.java)
    }

    @Singleton
    @Provides
    fun provideStedioFitnessRemoteDataSourceInstance(api: StedioFitnessApi): StedioFitnessRemoteDataSource {
        return StedioFitnessRemoteDataSourceImpl(api = api)
    }

}