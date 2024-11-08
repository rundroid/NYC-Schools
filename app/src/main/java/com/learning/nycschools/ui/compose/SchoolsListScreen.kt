package com.learning.nycschools.ui.compose

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.learning.nycschools.api.model.SchoolData
import com.learning.nycschools.ui.SchoolListsViewModel
import com.learning.nycschools.utils.DataState

typealias SchoolItemClick = (SchoolData) -> Unit

@Composable
fun SchoolsListScreen(schoolListsViewModel: SchoolListsViewModel, onItemClick: SchoolItemClick) {
    val dataState by schoolListsViewModel.schoolsDataFlow.collectAsStateWithLifecycle()

    AnimatedContent(targetState = dataState, label = "SchoolsListScreen") { targetState ->
        when (targetState) {
            is DataState.Loading -> {
                LoadingDataIndicator("Loading schools data...")
            }

            is DataState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(targetState.data) { schoolData ->
                        SchoolDataItem(schoolData, onItemClick)
                        HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
                    }
                }
            }

            is DataState.Failure -> {
                ErrorWithTryAgain(
                    errorMessage = "Unable to get schools data",
                    onTryAgain = schoolListsViewModel::refreshSchoolsData
                )
            }
        }
    }
}


@Composable
fun SchoolDataItem(schoolData: SchoolData, onItemClick: SchoolItemClick) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick.invoke(schoolData)
            }
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        with(schoolData) {
            Text("Name: ${schoolName.orEmpty()}")
            Text("Email: ${schoolEmail.orEmpty()}")
            Text("City: ${city.orEmpty()}")
        }
    }
}