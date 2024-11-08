package com.learning.nycschools.api.service

import com.learning.nycschools.api.retrofit.SchoolDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SchoolDataServiceModule {

    @Provides
    @Singleton
    fun providesSchoolDataService(retrofit: Retrofit): SchoolDataService {
        return retrofit.create(SchoolDataService::class.java)
    }
}