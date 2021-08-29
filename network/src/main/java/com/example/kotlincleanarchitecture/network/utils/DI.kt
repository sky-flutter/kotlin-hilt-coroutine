package com.example.kotlincleanarchitecture.network.utils

import android.content.Context
import com.example.kotlincleanarchitecture.network.ApiServices
import com.example.kotlincleanarchitecture.network.BuildConfig
import com.example.kotlincleanarchitecture.network.URLFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val READ_TIMEOUT = 30L
private const val WRITE_TIMEOUT = 30L
private const val CONNECTION_TIMEOUT = 10L
private const val CACHE_SIZE_BYTES = 10 * 1024 * 1024L

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val mURLFactory = URLFactory()
        return Retrofit.Builder()
            .baseUrl(mURLFactory())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideCache(context: Context): Cache {
        return Cache(File(context.cacheDir.absolutePath), CACHE_SIZE_BYTES)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(Interceptor {
                val requestBuilder = it.request().newBuilder()
                it.proceed(requestBuilder.build())
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            })
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }
}