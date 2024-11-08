package com.learning.nycschools.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingCommand
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.stateIn

interface RestartableSharingStarted : SharingStarted {
    fun restart()
}

class RestartableSharingStartedImpl(private val sharingStarted: SharingStarted) :
    RestartableSharingStarted {
    private val restartableFlow = MutableSharedFlow<SharingCommand>(extraBufferCapacity = 2)

    override fun restart() {
        restartableFlow.tryEmit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE)
        restartableFlow.tryEmit(SharingCommand.START)
    }

    override fun command(subscriptionCount: StateFlow<Int>): Flow<SharingCommand> {
        return merge(restartableFlow, sharingStarted.command(subscriptionCount))
    }
}

interface RestartableStateFlow<T> : StateFlow<T> {
    fun restart()
}

fun <T> Flow<T>.restartableStateIn(
    coroutineScope: CoroutineScope,
    started: SharingStarted,
    initialValue: T
): RestartableStateFlow<T> {
    val restartableSharing = RestartableSharingStartedImpl(started)
    val stateFlow = stateIn(coroutineScope, restartableSharing, initialValue)
    return object : RestartableStateFlow<T>, StateFlow<T> by stateFlow {
        override fun restart() {
            restartableSharing.restart()
        }
    }
}