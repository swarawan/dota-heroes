package com.swarawan.dotaheroes.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.swarawan.dotaheroes.BuildConfig
import com.swarawan.dotaheroes.di.AppContext
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by rioswarawan on 12/24/17.
 */

@Module
class AppModule(val app: Application) {

    @Provides
    @AppContext
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val timeout: Long = 30 * 1000
        var logger = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .build()
    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.OPENDOTA_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }
}