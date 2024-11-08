package com.learning.nycschools.ui.compose

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.learning.nycschools.api.model.SchoolEntity
import com.learning.nycschools.ui.SchoolDetailsViewModel
import com.learning.nycschools.utils.DataState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun SchoolDetailsScreen(
    detailsViewModel: SchoolDetailsViewModel,
    schoolDetails: NavRoutes.SchoolDetails
) {
    val dataState by detailsViewModel.schoolDetailsFlow.collectAsStateWithLifecycle()
    AnimatedContent(dataState, label = "SchoolDetailsScreen") { targetState ->
        when (targetState) {
            is DataState.Loading -> {
                LoadingDataIndicator("Loading school data...")
            }

            is DataState.Success -> {
                if (targetState.data.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp, vertical = 20.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text("Details not found for school: \n${schoolDetails.schoolName}")
                    }
                } else {
                    SchoolEntity(targetState.data[0])
                }
            }

            is DataState.Failure -> {
                ErrorWithTryAgain(errorMessage = "Unable get school data") {
                    detailsViewModel.refreshSchoolDetails()
                }
            }
        }
    }
}

@Composable
fun SchoolEntity(schoolEntity: SchoolEntity) {
    val data: ImmutableList<Pair<String, String>> = remember(schoolEntity) {
        with(schoolEntity) {
            persistentListOf(
                "DBN" to dbn.orEmpty(),
                "School name" to schoolName.orEmpty(),
                "SAT test takers" to numOfSatTestTakers.orEmpty(),
                "SAT Math average score" to satMathAvgScore.orEmpty(),
                "SAT critical reading average score" to satCriticalReadingAvgScore.orEmpty(),
                "SAT writing average score" to satWritingAvgScore.orEmpty()
            )
        }
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(data) { pair ->
            Text(
                "${pair.first}: ${pair.second}",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 4.dp, bottom = 4.dp)
            )
        }
    }
}