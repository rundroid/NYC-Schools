package com.learning.nycschools.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.nycschools.api.repository.SchoolDataRepository
import com.learning.nycschools.utils.DataState
import com.learning.nycschools.utils.restartableStateIn
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Named

@HiltViewModel(assistedFactory = SchoolDetailsViewModel.Factory::class)
class SchoolDetailsViewModel
@AssistedInject constructor(
    private val schoolDataRepository: SchoolDataRepository,
    @Named("default") private val defaultDispatcher: CoroutineDispatcher,
    @Assisted private val schoolDBN: String
) : ViewModel() {

    val schoolDetailsFlow = flow {
        emit(DataState.Loading)
        schoolDataRepository.getSchoolDetails(schoolDBN).fold(
            {
                emit(DataState.Success(it))
            },
            {
                emit(DataState.Failure(it))
            }
        )
    }.flowOn(defaultDispatcher)
        .restartableStateIn(viewModelScope, SharingStarted.Lazily, DataState.Loading)

    fun refreshSchoolDetails() {
        schoolDetailsFlow.restart()
    }

    @AssistedFactory
    interface Factory {
        fun create(schoolDBN: String): SchoolDetailsViewModel
    }
}