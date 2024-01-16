package com.example.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavOptionsBuilder
import com.example.navigation.utils.DestinationRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Stable
@Singleton
class Navigator @Inject constructor() {
    private val _actions = MutableSharedFlow<Action>(
        replay = 0,
        extraBufferCapacity = 10
    )
    val actions: Flow<Action> = _actions.asSharedFlow()

    fun navigate(destination: DestinationRoute, navOptions: NavOptionsBuilder.() -> Unit = {}) {
        _actions.tryEmit(
            Action.Navigate(destination = destination) {
                launchSingleTop = true
                restoreState = true
            }
        )
    }

    fun back() {
        _actions.tryEmit(Action.Back)
    }

    sealed class Action {
        data class Navigate(
            val destination: DestinationRoute,
            val navOptions: NavOptionsBuilder.() -> Unit
        ) : Action()

        object Back : Action()
    }
}
