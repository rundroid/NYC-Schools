package com.learning.nycschools.api.retrofit

import com.learning.nycschools.api.SCHOOLS_LIST_END_POINT
import com.learning.nycschools.api.SCHOOL_DATA_END_POINT
import com.learning.nycschools.api.model.SchoolData
import com.learning.nycschools.api.model.SchoolEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolDataService {

    @GET(SCHOOLS_LIST_END_POINT)
    suspend fun getNYSchools(
        @Query("\$\$app_token") appToken: String,
        @Query("\$limit") limit: Int = 200
    ): List<SchoolData>

    @GET(SCHOOL_DATA_END_POINT)
    suspend fun getSchoolEntity(
        @Query("\$\$app_token") appToken: String,
        @Query("dbn") dbn: String
    ): List<SchoolEntity>
}