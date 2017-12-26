package com.swarawan.dotaheroes.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.swarawan.dotaheroes.R
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepository
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepositoryImplementation
import com.swarawan.dotaheroes.data.data.DotaService
import com.swarawan.dotaheroes.db.AppDatabase
import com.swarawan.dotaheroes.di.AppContext
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by rioswarawan on 12/24/17.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideOpenDotaService(retrofit: Retrofit): DotaService = retrofit.create(DotaService::class.java)

    @Provides
    @Singleton
    fun provideDotaRepository(repositoryImplementation: DotaHeroesRepositoryImplementation): DotaHeroesRepository = repositoryImplementation

    @Provides
    @Singleton
    fun provideAppDatabase(@AppContext context: Context): AppDatabase {
        val databaseName: String = context.getString(R.string.app_name)
        return Room.databaseBuilder(context, AppDatabase::class.java, databaseName).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideHeroDao(database: AppDatabase) = database.heroDao()
}