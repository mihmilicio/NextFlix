package io.github.mihmilicio.nextflix.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.mihmilicio.nextflix.data.datasource.SerieRemoteDataSource
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "https://www.episodate.com/api/"

    private val json = Json { ignoreUnknownKeys = true }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .baseUrl(BASE_URL).client(okHttpClient).build()

    @Singleton
    @Provides
    fun provideSerieApi(retrofit: Retrofit): SerieRemoteDataSource = retrofit.create(
        SerieRemoteDataSource::class.java
    )

}