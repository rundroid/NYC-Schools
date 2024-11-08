package com.learning.nycschools.api.repository

import com.learning.nycschools.api.SOCRATA_APP_TOKEN
import com.learning.nycschools.api.model.SchoolData
import com.learning.nycschools.api.model.SchoolEntity
import com.learning.nycschools.api.retrofit.SchoolDataService
import javax.inject.Inject

class SchoolDataRepository @Inject constructor(private val schoolDataService: SchoolDataService) {

    suspend fun getNYSchools(): Result<List<SchoolData>> {
        return kotlin.runCatching {
            schoolDataService.getNYSchools(SOCRATA_APP_TOKEN)
        }
    }

    suspend fun getSchoolDetails(dbn: String): Result<List<SchoolEntity>> {
        return kotlin.runCatching {
            schoolDataService.getSchoolEntity(SOCRATA_APP_TOKEN, dbn)
        }
    }
}