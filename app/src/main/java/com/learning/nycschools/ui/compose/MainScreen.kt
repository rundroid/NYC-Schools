package com.learning.nycschools.ui.compose

import androidx.annotation.Keep
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.learning.nycschools.ui.SchoolDetailsViewModel
import com.learning.nycschools.ui.SchoolListsViewModel
import kotlinx.serialization.Serializable

@Keep
@Serializable
data object MainScreenNavHost

@Keep
sealed interface NavRoutes {

    @Keep
    @Serializable
    data object SchoolsList : NavRoutes {
        override fun getTitle(): String? = null
        override fun isTopLevelDestination(): Boolean = true
    }

    @Keep
    @Serializable
    data class SchoolDetails(val schoolName: String, val schoolDBN: String) : NavRoutes {
        override fun getTitle(): String = schoolName
        override fun isTopLevelDestination(): Boolean = false
    }

    fun getTitle(): String?

    fun isTopLevelDestination(): Boolean

    companion object {

        private fun navRouteFromBackStackEntry(currentEntry: NavBackStackEntry): NavRoutes? {
            val route = currentEntry.destination.route.orEmpty()
            return when {
                route.startsWith(SchoolsList::class.java.name.replace('$', '.')) -> {
                    currentEntry.toRoute<SchoolsList>()
                }

                route.startsWith(SchoolDetails::class.java.name.replace('$', '.')) -> {
                    currentEntry.toRoute<SchoolDetails>()
                }

                else -> null
            }
        }

        fun titleFromRouteName(currentEntry: NavBackStackEntry?): String? {
            return currentEntry?.let { navRouteFromBackStackEntry(currentEntry)?.getTitle() }
        }

        fun isTopLevelDestination(currentEntry: NavBackStackEntry?): Boolean {
            return currentEntry?.let { navRouteFromBackStackEntry(currentEntry) }
                ?.isTopLevelDestination() ?: true
        }
    }

}

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    MaterialTheme.typography.titleLarge
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.SchoolsList,
        route = MainScreenNavHost::class
    ) {
        composable<NavRoutes.SchoolsList> {
            val schoolListsViewModel = hiltViewModel<SchoolListsViewModel>()
            SchoolsListScreen(schoolListsViewModel) { data ->
                navController.navigate(
                    route = NavRoutes.SchoolDetails(data.schoolName.orEmpty(), data.dbn.orEmpty())
                )
            }
        }
        composable<NavRoutes.SchoolDetails> { backStackEntry ->
            val details: NavRoutes.SchoolDetails = backStackEntry.toRoute()
            val detailsViewModel =
                hiltViewModel<SchoolDetailsViewModel, SchoolDetailsViewModel.Factory>(
                    creationCallback = { factory ->
                        factory.create(details.schoolDBN)
                    })
            SchoolDetailsScreen(detailsViewModel, details)
        }
    }
}