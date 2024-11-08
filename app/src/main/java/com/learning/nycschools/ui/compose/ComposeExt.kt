package com.learning.nycschools.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
inline fun <reified T : Any, reified VM : ViewModel> NavBackStackEntry.createViewModel(
    navController: NavHostController
): VM {
    val parentEntry = remember(this) {
        navController.getBackStackEntry(T::class)
    }
    return hiltViewModel<VM>(parentEntry)
}