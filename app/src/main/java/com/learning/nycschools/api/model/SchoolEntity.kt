package com.learning.nycschools.api.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SchoolEntity(
    @SerialName("dbn")
    val dbn: String? = null,
    @SerialName("num_of_sat_test_takers")
    val numOfSatTestTakers: String? = null,
    @SerialName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String? = null,
    @SerialName("sat_math_avg_score")
    val satMathAvgScore: String? = null,
    @SerialName("sat_writing_avg_score")
    val satWritingAvgScore: String? = null,
    @SerialName("school_name")
    val schoolName: String? = null
)