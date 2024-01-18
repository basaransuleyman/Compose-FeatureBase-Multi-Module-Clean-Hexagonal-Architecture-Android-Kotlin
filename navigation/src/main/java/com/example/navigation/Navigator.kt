package com.example.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavOptionsBuilder
import com.example.core.navigation.NavigationService
import com.example.navigation.utils.DestinationRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() : NavigationService {
    private val _actions = MutableSharedFlow<Action>(
        replay = 0,
        extraBufferCapacity = 10
    )
    val actions: Flow<Action> = _actions.asSharedFlow()
    override fun navigateTo(
        destination: DestinationRoute,
        navOptions: NavOptionsBuilder.() -> Unit
    ) {
        _actions.tryEmit(
            Action.Navigate(destination = destination, navOptions = navOptions)
        )
    }

    override fun goBack() {
        _actions.tryEmit(Action.Back)
    }

    sealed class Action {
        data class Navigate(
            val destination: DestinationRoute,
            val navOptions: NavOptionsBuilder.() -> Unit
        ) : Action()

        data object Back : Action()
    }

}
