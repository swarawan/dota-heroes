package com.swarawan.dotaheroes.di.module

import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepository
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepositoryImplementation
import com.swarawan.dotaheroes.data.data.DotaService
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

}