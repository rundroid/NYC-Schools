package com.learning.nycschools.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.nycschools.api.repository.SchoolDataRepository
import com.learning.nycschools.utils.DataState
import com.learning.nycschools.utils.restartableStateIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SchoolListsViewModel @Inject constructor(
    private val schoolDataRepository: SchoolDataRepository,
    @Named("default") private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    val schoolsDataFlow = flow {
        emit(DataState.Loading)
        schoolDataRepository.getNYSchools().fold({
            emit(DataState.Success(it))
        }, {
            emit(DataState.Failure(it))
        })
    }.flowOn(defaultDispatcher).restartableStateIn(
        viewModelScope,
        SharingStarted.Lazily,
        DataState.Loading
    )

    fun refreshSchoolsData() {
        schoolsDataFlow.restart()
    }
}